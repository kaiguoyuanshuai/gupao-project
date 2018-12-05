package com.gupao.edu.cache.template;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.gupao.edu.cache.interfaces.CacheLoadable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 作者：Administrator
 * 时间：2018/12/5
 */
@Component
public class CacheTemplateService {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取缓存信息的线程安全的模板方法
     *
     * @param key
     * @param expire
     * @param timeUnit
     * @param clazz
     * @param cacheLoadable
     * @param <T>
     * @return
     */
    public <T> T findCache(String key, long expire, TimeUnit timeUnit, TypeReference<T> clazz, CacheLoadable<T> cacheLoadable) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        String json = String.valueOf(valueOperations.get(key));

        if (StringUtils.isNotEmpty(json) && !json.equalsIgnoreCase("null")) {
            return JSON.parseObject(json, clazz);
        } else {
            synchronized (this) {
                json = String.valueOf(valueOperations.get(key));
                if (StringUtils.isNotEmpty(json) && !json.equalsIgnoreCase("null")) {
                    return JSON.parseObject(json, clazz);
                }
                T result = cacheLoadable.load();
                valueOperations.set(key, JSON.toJSON(result), expire, timeUnit);
                return result;
            }
        }

    }
}
