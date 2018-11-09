package com.gupao.edu.user.vo;

import com.gupao.edu.serviceext.common.dto.BaseBean;

/**
 * 用户信息实体类
 * Created by zhengkk19738 on 2018/3/8.
 */
public class UserInfoBean extends BaseBean {
    /**
     * 用户ID
     */
    private String obid;

    /**
     * 用户名
     */
    private String account;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户真实姓名
     */
    private String realName;

    /**
     * 用户所属单位
     */
    private String departmentId;

    /*private Set<GrantedAuthority> authorities;*/


    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    public String getObid() {
        return obid;
    }

    public void setObid(String obid) {
        this.obid = obid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
/*

    public Set<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
*/

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
