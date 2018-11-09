package com.gupao.edu.user.services;

import com.gupao.edu.user.service.UserManageService;
import com.gupao.edu.user.vo.UserInfoBean;
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
        return null;
    }
}
