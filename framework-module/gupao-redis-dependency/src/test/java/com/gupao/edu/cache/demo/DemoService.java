package com.gupao.edu.cache.demo;

import com.alibaba.fastjson.TypeReference;
import com.gupao.edu.cache.interfaces.CacheLoadable;
import com.gupao.edu.cache.template.CacheTemplateService;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 作者：Administrator
 * 时间：2018/12/5
 */
public class DemoService {

    private CacheTemplateService cacheTemplateService;

    public List<Object> queryByTemplate() {
        return cacheTemplateService.findCache("key", 1000, TimeUnit.MILLISECONDS, new TypeReference<List<Object>>() {
        }, new CacheLoadable<List<Object>>() {
            @Override
            public List<Object> load() {
                // return mapper.findbuId();
                return null;
            }
        });
    }
}
