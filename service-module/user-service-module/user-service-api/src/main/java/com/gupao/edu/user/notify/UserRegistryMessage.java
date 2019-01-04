package com.gupao.edu.user.notify;

import java.io.Serializable;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/1/4
 */
public class UserRegistryMessage implements Serializable {

    private String userId;

    private String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
