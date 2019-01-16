package com.gupao.edu.seckill.business;

import com.google.common.collect.Lists;
import com.gupao.edu.base.service.BaseService;
import com.gupao.edu.seckill.constant.SecKillConstant;
import com.gupao.edu.seckill.dto.SecKillActivityResp;
import com.gupao.edu.seckill.dto.SeckillInfoRequest;
import com.gupao.edu.seckill.dto.SeckillRequest;
import com.gupao.edu.seckill.service.SeckillBusinessService;
import com.gupao.edu.seckill.vo.SecKillActivity;
import com.gupao.edu.seckill.vo.SecKillActivityMessage;
import com.gupao.edu.serviceext.common.dto.BaseResponse;
import org.joda.time.DateTime;
import org.redisson.api.RScript;
import org.redisson.api.RedissonClient;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/1/11
 */
@Service("secKillBusinessInvokerService")
public class SecKillBusinessInvokerServiceImpl extends BaseService implements SecKillBusinessInvokerService {

    @Autowired
    private SeckillBusinessService seckillBusinessService;

    @Autowired
    private RedissonClient redisson;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     *
     * @param seckillRequest
     * @return
     */
    @Override
    public BaseResponse seckill(SeckillRequest seckillRequest) {
        SecKillActivityResp secKillActivityResp = new SecKillActivityResp();
        if (!validateParam(seckillRequest)) {
            LOGGER.error("参数异常");
            return secKillActivityResp.fail();
        }
        long startTime = System.currentTimeMillis();
        SeckillInfoRequest seckillInfoRequest = new SeckillInfoRequest();
        seckillInfoRequest.setId(Integer.valueOf(seckillRequest.getSeckillId()));
        SecKillActivity secKillActivity = seckillBusinessService.querySeckillInfo(seckillInfoRequest);
        System.out.println("time1：" + (System.currentTimeMillis() - startTime));
        //判断时间是否已经失效
        if (new DateTime().isAfter(new DateTime(seckillInfoRequest.getSeckillEndTime()))) {
            LOGGER.error("秒杀活动已结束");
            return secKillActivityResp.fail();
        }
        System.out.println("time2：" + (System.currentTimeMillis() - startTime));


        RScript s = redisson.getScript();
        String res = s.scriptLoad(SecKillConstant.DECR_SECKILL_GOODS__COUNT_SCRIPT);

        Long eval = redisson.getScript().evalSha(RScript.Mode.READ_WRITE,
                res,
                RScript.ReturnType.INTEGER, Lists.newArrayList(seckillRequest.getSeckillId()));

        //RLongAdder atomicLongNew = redisson.getLongAdder(SecKillConstant.SECKILL_PRE_COUNT + seckillRequest.getSeckillId());
        LOGGER.info("剩余资格:{}", eval);

        System.out.println("time3：" + (System.currentTimeMillis() - startTime));

        //这里会出现并发问题，但是为了性能，多放一些进入队列无妨 ;
        // 如果加锁的话 秒杀的时候会出现性能不高的情况
        if (eval < 0) {
            //设置为 0
            //atomicLongNew.reset();
            //TODO 通知界面被抢购结束了
            LOGGER.error("秒杀结束，没有抢到秒杀队列资格!");
            return secKillActivityResp.fail();
        }


        System.out.println("time4：" + (System.currentTimeMillis() - startTime));

        SecKillActivityMessage secKillActivityMessage = new SecKillActivityMessage();
        BeanUtils.copyProperties(secKillActivity, secKillActivityMessage);
        amqpTemplate.convertAndSend(SecKillConstant.SECKILL_DO_MQ_MESSAGE, secKillActivityMessage);
        System.out.println("time5：" + (System.currentTimeMillis() - startTime));
        LOGGER.info("进入秒杀队列");
        return secKillActivityResp.success();
    }

    private boolean validateParam(SeckillRequest seckillRequest) {

        if (seckillRequest == null) {
            return false;
        }

        return true;
    }
}
