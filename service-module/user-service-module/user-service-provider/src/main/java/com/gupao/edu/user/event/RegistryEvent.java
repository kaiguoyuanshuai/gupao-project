package com.gupao.edu.user.event;

import com.gupao.edu.user.dal.entity.User;
import org.springframework.context.ApplicationEvent;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/1/4
 */
public class RegistryEvent extends ApplicationEvent {
    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 注册来源
     */
    private String source;

    public RegistryEvent(User user) {
        super(user);
        this.userId = String.valueOf(user.getId());
        this.userName = user.getUsername();
        this.realName = user.getRealname();
    }


    public RegistryEvent(String userId, String userName, String realName, String source) {
        super(userId);
        this.userId = userId;
        this.userName = userName;
        this.realName = realName;
    }

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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "RegistryEvent{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
