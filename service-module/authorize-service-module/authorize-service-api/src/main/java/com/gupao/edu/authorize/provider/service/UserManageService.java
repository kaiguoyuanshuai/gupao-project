package com.gupao.edu.authorize.provider.service;


import com.gupao.edu.authorize.vo.UserInfoBean;

/**
 * Created by zhengkk19738 on 2018/3/8.
 */
public interface UserManageService {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public UserInfoBean loadUserInfo(String username)  ;
}
