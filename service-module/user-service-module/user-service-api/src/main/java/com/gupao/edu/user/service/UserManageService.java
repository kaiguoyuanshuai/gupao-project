package com.gupao.edu.user.service;


import com.gupao.edu.user.vo.UserInfoBean;

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
