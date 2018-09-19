package com.gupao.edu.user.dto;

import com.gupao.edu.serviceext.common.dto.BaseRequest;

/**
 * Created by Administrator on 2018/7/1.
 */
public class UserLoginRequest extends BaseRequest {
    private static final long serialVersionUID = -28020912345922318L;

    private String userName;
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
