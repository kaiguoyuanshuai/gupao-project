package com.gupao.edu.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 作者：Administrator
 * 时间：2018/7/3
 */
@Component("gpMallWebProperties")
public class GpMallWebProperties {

    @Value("${sso.access.url}")
    private String ssoAccessUrl;

    @Value("${activity.access.url}")
    private String activityAccessUrl;


    public String getSsoAccessUrl() {
        return ssoAccessUrl;
    }

    public void setSsoAccessUrl(String ssoAccessUrl) {
        this.ssoAccessUrl = ssoAccessUrl;
    }

    public String getActivityAccessUrl() {
        return activityAccessUrl;
    }

    public void setActivityAccessUrl(String activityAccessUrl) {
        this.activityAccessUrl = activityAccessUrl;
    }
}
