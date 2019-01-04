package com.gupao.edu.user.service;

import com.gupao.edu.serviceext.common.dto.BaseResponse;
import com.gupao.edu.user.dto.UserRequest;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/1/4
 */
public interface IUserRegistryService {

    /**
     * 用户注册
     *
     * @param userRequest
     * @return
     */
    public BaseResponse registry(UserRequest userRequest);


}
