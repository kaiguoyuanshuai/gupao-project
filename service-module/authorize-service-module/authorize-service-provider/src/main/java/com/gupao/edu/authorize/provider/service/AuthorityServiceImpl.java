package com.gupao.edu.authorize.provider.service;


import com.gupao.edu.authorize.metadata.AuthType;
import com.gupao.edu.authorize.vo.AuthDetailBean;
import com.gupao.edu.authorize.vo.auth.AuthorityBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by zhengkk19738 on 2018/3/8.
 */

@Service("authorityService")
public class AuthorityServiceImpl implements AuthorityService {
    @Override
    public void addAuthority(AuthorityBean entity) {

    }

    @Override
    public void saveAuthorityRoleRelation(String roleId, String authId) {

    }

    @Override
    public void modifyAuthority(AuthorityBean entity) {

    }

    @Override
    public void removeAuthority(String obid) {

    }

    @Override
    public List<AuthDetailBean> getAuthDetailInfos() {
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public List<AuthDetailBean> getAuthDetailByType(AuthType type) {

        List<AuthDetailBean> lists = new ArrayList<>();
        AuthDetailBean authDetailBean = new AuthDetailBean();
        authDetailBean.setExpression("/**");
        authDetailBean.setAuthCode("ROLE_ADMIN");
        lists.add(authDetailBean);
        AuthDetailBean authDetailBean2 = new AuthDetailBean();
        authDetailBean2.setExpression("/index.html");
        authDetailBean2.setAuthCode("ROLE_ADMIN");
        lists.add(authDetailBean2);
        return lists;
    }

    @Override
    public ConfigAttribute findAuthAttribute(AuthType type, String resourceId) {
        return null;
    }

    @Override
    public List<String> getUserAuthorities(String userName) {
        List<String> userAuthorities = new ArrayList<>();

        userAuthorities.add(new String("ROLE_ADMIN"));

        return userAuthorities;
    }
}
