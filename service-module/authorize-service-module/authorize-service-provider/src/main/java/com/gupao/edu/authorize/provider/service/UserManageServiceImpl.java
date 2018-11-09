package com.gupao.edu.authorize.provider.service;

import com.gupao.edu.authorize.vo.UserInfoBean;
import org.springframework.stereotype.Service;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/11/9
 */
@Service("userManageService")
public class UserManageServiceImpl implements UserManageService {


    @Override
    public UserInfoBean loadUserInfo(String username) {

        UserInfoBean userInfoBean = new UserInfoBean() ;
        userInfoBean.setAccount("admin");
        userInfoBean.setPassword("$2a$10$BDF7icM2WaWF2UUTfoPHz.kgddGj6Z1QFn6NICnMibgGlAMxvEYEe");

        return userInfoBean;
    }
}
