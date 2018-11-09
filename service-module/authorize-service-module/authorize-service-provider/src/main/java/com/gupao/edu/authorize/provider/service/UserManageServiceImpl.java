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
        userInfoBean.setPassword("$2a$10$ENvP2NJ2OrUcl9LtjJBSGejgxpDyTKGxYkEOC92z17iD5DDC1ylVm");

        return userInfoBean;
    }
}
