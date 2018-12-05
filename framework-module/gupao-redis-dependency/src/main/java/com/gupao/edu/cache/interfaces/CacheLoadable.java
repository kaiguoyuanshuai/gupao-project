package com.gupao.edu.cache.interfaces;

/**
 * 作者：Administrator
 * 时间：2018/12/5
 */
public interface CacheLoadable<T> {

    /**
     * 获取数据
     *
     * @return
     */
    T load();
}
