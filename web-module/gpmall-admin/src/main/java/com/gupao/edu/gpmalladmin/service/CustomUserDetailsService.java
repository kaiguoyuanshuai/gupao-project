package com.gupao.edu.gpmalladmin.service;


import com.gupao.edu.authorize.provider.service.AuthorityService;
import com.gupao.edu.authorize.provider.service.UserManageService;
import com.gupao.edu.authorize.vo.UserInfoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhengkk19738 on 2018/3/8.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserManageService userManageService;

    @Autowired
    private AuthorityService authorityService;

    public CustomUserDetailsService() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfoBean userInfoBean = userManageService.loadUserInfo(username);
        if (userInfoBean == null) {
            throw new UsernameNotFoundException("账户名不存在!");
        }
        List<String> userAuthorities = authorityService.getUserAuthorities(userInfoBean.getAccount());

        Set<SimpleGrantedAuthority> authority = new HashSet<SimpleGrantedAuthority>();

        for (String userAuthority : userAuthorities) {
            authority.add(new SimpleGrantedAuthority(userAuthority));
        }

        return new User(userInfoBean.getAccount(), userInfoBean.getPassword(), authority);
    }


}
