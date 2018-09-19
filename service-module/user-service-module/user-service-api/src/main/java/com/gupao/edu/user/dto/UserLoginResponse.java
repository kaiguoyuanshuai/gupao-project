package com.gupao.edu.user.dto;

import com.gupao.edu.serviceext.common.dto.BaseResponse;

/**
 * Created by Administrator on 2018/7/1.
 */
public class UserLoginResponse extends BaseResponse {

    private static final long serialVersionUID = 6806603208806342464L;
    private Integer uid;
    private String avatar;
    private String mobile;
    private String token;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
