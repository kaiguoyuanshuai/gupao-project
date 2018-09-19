package com.gupao.edu.user.service;

import com.gupao.edu.serviceext.common.dto.BaseResponse;
import com.gupao.edu.user.dto.CheckAuthRequest;
import com.gupao.edu.user.dto.CheckAuthResponse;
import com.gupao.edu.user.dto.UserLoginResponse;

import java.util.Map;

/**
 * JWT 校验服务
 * Created by Administrator on 2018/7/1.
 */
public interface IJsonWebTokenService {

    /**
     * 校验jwt的正确性和真伪
     *
     * @param checkAuthRequest
     * @return CheckAuthResponse
     */
    public CheckAuthResponse validateJwt(CheckAuthRequest checkAuthRequest);


}
