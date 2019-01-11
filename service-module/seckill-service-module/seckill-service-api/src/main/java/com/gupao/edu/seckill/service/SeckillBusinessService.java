package com.gupao.edu.seckill.service;

import com.gupao.edu.seckill.dto.SeckillInfoRequest;
import com.gupao.edu.seckill.vo.SecKillActivity;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/1/11
 */
public interface SeckillBusinessService {


    /**
     * 查询秒杀信息
     *
     * @param seckillInfoRequest
     * @return
     */
    public SecKillActivity querySeckillInfo(SeckillInfoRequest seckillInfoRequest);

}
