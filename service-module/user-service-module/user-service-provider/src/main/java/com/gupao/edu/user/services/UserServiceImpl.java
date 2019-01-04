package com.gupao.edu.user.services;

import com.gupao.edu.serviceext.common.dto.BaseResponse;
import com.gupao.edu.user.dal.entity.User;
import com.gupao.edu.user.dal.persistence.UserMapper;
import com.gupao.edu.user.dto.UserRequest;
import com.gupao.edu.user.dto.UserResponse;
import com.gupao.edu.user.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/1/4
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public BaseResponse<User> insert(UserRequest userRequest) {
        UserResponse userResponse = new UserResponse();
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);
        userMapper.insertSelective(user);
        return userResponse.success(user);
    }
}
