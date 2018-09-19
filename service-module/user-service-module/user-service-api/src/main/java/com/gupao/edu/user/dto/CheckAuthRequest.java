package com.gupao.edu.user.dto;

import com.gupao.edu.serviceext.common.dto.BaseRequest;

/**
 * Created by Administrator on 2018/7/1.
 */
public class CheckAuthRequest extends BaseRequest {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "CheckAuthRequest{" +
                "token='" + token + '\'' +
                '}';
    }
}
