package com.gupao.edu.seckill.business;

import com.gupao.edu.seckill.dto.SeckillRequest;
import com.gupao.edu.serviceext.common.dto.BaseResponse;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/1/11
 */
public interface SecKillBusinessInvokerService {

    /**
     * 开始执行秒杀
     *
     * @param seckillRequest
     * @return
     */
    public BaseResponse seckill(SeckillRequest seckillRequest);

}
