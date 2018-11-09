package com.gupao.edu.gpmalladmin.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 2018/1/10.
 *
 * @author zlf
 * @since 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "admin.security")
@EnableConfigurationProperties
public class SecurityConfProperties {

    private String signOutUrl = "/merryyou-signOut.html";

    /**
     * 记住我的有效时间秒
     */
    private int rememberMeSeconds = 60 * 60 * 24 * 7;

    /**
     * session配置过期和并发登录
     */
    private SessionProperties session = new SessionProperties();

    public String getSignOutUrl() {
        return signOutUrl;
    }

    public void setSignOutUrl(String signOutUrl) {
        this.signOutUrl = signOutUrl;
    }

    public int getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(int rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }

    public SessionProperties getSession() {
        return session;
    }

    public void setSession(SessionProperties session) {
        this.session = session;
    }
}
