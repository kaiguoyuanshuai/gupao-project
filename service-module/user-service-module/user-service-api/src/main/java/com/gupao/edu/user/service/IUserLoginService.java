package com.gupao.edu.user.service;

import com.gupao.edu.user.dto.UserLoginRequest;
import com.gupao.edu.user.dto.UserLoginResponse;

/**
 * Created by Administrator on 2018/7/1.
 */
public interface IUserLoginService {

    /**
     * 用户登录请求
     *
     * @param userLoginRequest
     * @return
     */
    UserLoginResponse login(UserLoginRequest userLoginRequest);


}
