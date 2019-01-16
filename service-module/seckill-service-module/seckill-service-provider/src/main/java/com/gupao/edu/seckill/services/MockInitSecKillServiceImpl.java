package com.gupao.edu.seckill.services;

import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import com.gupao.edu.base.service.BaseService;
import com.gupao.edu.cache.interfaces.CacheLoadable;
import com.gupao.edu.cache.template.CacheTemplateService;
import com.gupao.edu.seckill.constant.SecKillConstant;
import com.gupao.edu.seckill.dal.persistence.SecKillActivityMapper;
import com.gupao.edu.seckill.service.MockInitSecKillService;
import com.gupao.edu.seckill.vo.SecKillActivity;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.redisson.api.RLongAdder;
import org.redisson.api.RScript;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/1/11
 */
@Service("mockInitSecKillService")
public class MockInitSecKillServiceImpl extends BaseService implements MockInitSecKillService {

    @Autowired
    private SecKillActivityMapper secKillActivityMapper;


    @Autowired
    private RedissonClient redisson;

    @Autowired
    private CacheTemplateService cacheTemplateService;

    @Override
    public void initData(final String seckillId) {
        //获取atomicLong值 先销毁
        RLongAdder atomicLong = redisson.getLongAdder(SecKillConstant.SECKILL_PRE_COUNT + seckillId);
        atomicLong.destroy();
        LOGGER.info(">>>>>>>>>>>>>>>>初始化数据开始>>>>>>>>>>>>>>>>");
        SecKillActivity secKillActivity = new SecKillActivity();
        secKillActivity.setId(Integer.valueOf(seckillId));
        secKillActivity.setSeckillGoodsNum(10);
        secKillActivity.setSeckillStartTime(new DateTime().toDate());
        secKillActivity.setSeckillEndTime(new DateTime().plusDays(1).toDate());
        secKillActivityMapper.updateByPrimaryKey(secKillActivity);


        LOGGER.info(">>>>>>>>>>>>>>>>初始化秒杀缓存开始>>>>>>>>>>>>>>>>");
        SecKillActivity cacheEntity = cacheTemplateService.findCache(SecKillConstant.SECKILL_CACHE_KEY + secKillActivity.getId(),
                new Duration(new DateTime(secKillActivity.getSeckillStartTime()), new DateTime(secKillActivity.getSeckillEndTime())).getMillis(),
                TimeUnit.MILLISECONDS, new TypeReference<SecKillActivity>() {
                }, new CacheLoadable<SecKillActivity>() {
                    @Override
                    public SecKillActivity load() {
                        return secKillActivityMapper.selectByPrimaryKey(secKillActivity.getId());
                    }
                });
        LOGGER.info(">>>>>>>>>>>>>>>>初始化允许请求缓存开始>>>>>>>>>>>>>>>>");


        RScript s = redisson.getScript();
        String res = s.scriptLoad(SecKillConstant.INIT_SECKILL_GOODS__COUNT_SCRIPT);

        Integer eval = Integer.valueOf(redisson.getScript().evalSha(RScript.Mode.READ_WRITE,
                res,
                RScript.ReturnType.INTEGER, Lists.newArrayList(seckillId), new Duration(new DateTime(secKillActivity.getSeckillStartTime()),
                        new DateTime(secKillActivity.getSeckillEndTime())).getMillis(), SecKillConstant.CALL_COUNT * secKillActivity.getSeckillGoodsNum()));
        LOGGER.info("现有:" + String.valueOf(eval));

        LOGGER.info(">>>>>>>>>>>>>>>>初始化真实库存请求缓存开始>>>>>>>>>>>>>>>>");

    }
}
