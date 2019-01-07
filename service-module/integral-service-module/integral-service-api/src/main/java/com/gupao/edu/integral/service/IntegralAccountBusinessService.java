package com.gupao.edu.integral.service;

import com.gupao.edu.integral.dto.ScoreOperationRequest;
import com.gupao.edu.serviceext.common.dto.BaseResponse;

/*
 * 描述:
 * 积分扣减操作
 * @auth zhengkk19738
 * @time 2019/1/7
 */
public interface IntegralAccountBusinessService {

    /**
     * 扣减积分
     *
     * @param scoreOperationRequest
     * @return
     */
    public BaseResponse deductionScore(ScoreOperationRequest scoreOperationRequest);


    /**
     * 增加积分
     *
     * @param scoreOperationRequest
     * @return
     */
    public BaseResponse increaseScore(ScoreOperationRequest scoreOperationRequest);

}
