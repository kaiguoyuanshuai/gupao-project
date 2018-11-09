package com.gupao.edu.authorize.vo.auth;


import com.gupao.edu.authorize.metadata.AuthType;
import com.gupao.edu.serviceext.common.dto.BaseBean;

/**
 * 功能说明：<br/>
 * 权限对象,对应权限表
 * </br>
 * 开发人员：liuj(liuja1@strongit.com.cn)<br/>
 * 开发时间：2015年2月12日<br/>
 */
public class AuthorityBean extends BaseBean {
    private static final long serialVersionUID = 422084923514244393L;

    /**
     * 数据唯一主键
     */
    private String obid;

    /**
     * 权限唯一编码,默认前缀为ROLE_，根据<code>RoleVoter</code>配置决定
     */
    private String authCode;

    /**
     * 权限类型，具体取值见：{@link AuthType}
     */
    private String authType;

    /**
     * 权限对应的资源ID
     */
    private String resourceId;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getObid() {
        return obid;
    }

    public void setObid(String obid) {
        this.obid = obid;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }
}
