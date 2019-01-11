package com.gupao.edu.seckill.business;

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
import org.redisson.api.RLongAdder;
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

    @Override
    public BaseResponse seckill(SeckillRequest seckillRequest) {
        SecKillActivityResp secKillActivityResp = new SecKillActivityResp();
        if (!validateParam(seckillRequest)) {
            LOGGER.error("参数异常");
            return secKillActivityResp.fail();
        }

        SeckillInfoRequest seckillInfoRequest = new SeckillInfoRequest();
        seckillInfoRequest.setId(Integer.valueOf(seckillRequest.getSeckillId()));
        SecKillActivity secKillActivity = seckillBusinessService.querySeckillInfo(seckillInfoRequest);

        //判断时间是否已经失效
        if (new DateTime().isAfter(new DateTime(seckillInfoRequest.getSeckillEndTime()))) {
            LOGGER.error("秒杀活动已结束");
            return secKillActivityResp.fail();
        }

        RLongAdder atomicLongNew = redisson.getLongAdder(SecKillConstant.SECKILL_PRE_COUNT + seckillRequest.getSeckillId());

        if (atomicLongNew.sum() <= 0) {
            //TODO 通知界面被抢购结束了
            LOGGER.error("秒杀结束，没有抢到秒杀队列资格!");
            return secKillActivityResp.fail();
        }
        //递减队列资格
        atomicLongNew.decrement();
        SecKillActivityMessage secKillActivityMessage = new SecKillActivityMessage();
        BeanUtils.copyProperties(secKillActivity, secKillActivityMessage);
        amqpTemplate.convertAndSend(SecKillConstant.SECKILL_DO_MQ_MESSAGE, secKillActivityMessage);

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
