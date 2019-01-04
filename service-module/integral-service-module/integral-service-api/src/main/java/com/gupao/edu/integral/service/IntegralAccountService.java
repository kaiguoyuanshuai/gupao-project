package com.gupao.edu.integral.service;

import com.gupao.edu.integral.dto.IntegralAccountRequest;
import com.gupao.edu.serviceext.common.dto.BaseResponse;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/1/4
 */
public interface IntegralAccountService {

    /**
     * 初始化积分账号信息
     *
     * @param integralAccountRequest
     * @return
     */
    public BaseResponse initIntegralAccountInfo(IntegralAccountRequest integralAccountRequest);


}
