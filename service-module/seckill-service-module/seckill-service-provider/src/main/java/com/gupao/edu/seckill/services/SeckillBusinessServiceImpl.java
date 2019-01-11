package com.gupao.edu.seckill.services;

import com.alibaba.fastjson.TypeReference;
import com.gupao.edu.base.service.BaseService;
import com.gupao.edu.cache.interfaces.CacheLoadable;
import com.gupao.edu.cache.template.CacheTemplateService;
import com.gupao.edu.seckill.constant.SecKillConstant;
import com.gupao.edu.seckill.dal.persistence.SecKillActivityMapper;
import com.gupao.edu.seckill.dto.SeckillInfoRequest;
import com.gupao.edu.seckill.service.SeckillBusinessService;
import com.gupao.edu.seckill.vo.SecKillActivity;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/1/11
 */
@Service("seckillBusinessService")
public class SeckillBusinessServiceImpl extends BaseService implements SeckillBusinessService {

    @Autowired
    private CacheTemplateService cacheTemplateService;

    @Autowired
    private SecKillActivityMapper secKillActivityMapper;

    @Override
    public SecKillActivity querySeckillInfo(SeckillInfoRequest seckillInfoRequest) {
        SecKillActivity cacheEntity = cacheTemplateService.findCache(SecKillConstant.SECKILL_CACHE_KEY + seckillInfoRequest.getId(),
                new Duration(new DateTime(seckillInfoRequest.getSeckillEndTime()), new DateTime(seckillInfoRequest.getSeckillStartTime())).getMillis(),
                TimeUnit.MILLISECONDS, new TypeReference<SecKillActivity>() {
                }, new CacheLoadable<SecKillActivity>() {
                    @Override
                    public SecKillActivity load() {
                        return secKillActivityMapper.selectByPrimaryKey(seckillInfoRequest.getId());
                    }
                });
        return cacheEntity;
    }
}
