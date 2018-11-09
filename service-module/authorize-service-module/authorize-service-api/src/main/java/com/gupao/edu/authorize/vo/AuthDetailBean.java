package com.gupao.edu.authorize.vo;

import com.gupao.edu.authorize.metadata.AuthType;
import com.gupao.edu.authorize.vo.auth.AuthorityBean;

/**
 * 功能说明：<br/>
 * 联合查询权限表关联的资源，查询视图后获得数据
 */
public class AuthDetailBean extends AuthorityBean {

    private static final long serialVersionUID = -7588705473307498276L;

    /**
     * 权限对应的资源解析表达式，根据权限类型{@link AuthType}决定
     */
    private String expression;

    /**
     * 资源信息扩展或预留字段
     */
    private String extend;

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }
}
