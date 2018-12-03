package com.gupao.edu.authorize.provider.service;

import com.gupao.edu.authorize.vo.UserInfoBean;
import org.springframework.stereotype.Service;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/11/9
 */
@Service
public class UserManageServiceImpl implements UserManageService {


    @Override
    public UserInfoBean loadUserInfo(String username) {

        UserInfoBean userInfoBean = new UserInfoBean() ;
        userInfoBean.setAccount("admin");
        userInfoBean.setPassword("$2a$10$bo0uxHroAWpgGxOSYHNWm.0muLgwjBTcFNG.5/czWyXLazGKFC9rK");

        return userInfoBean;
    }
}
