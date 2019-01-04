package com.gupao.edu.user.services;

import com.gupao.edu.serviceext.common.dto.BaseResponse;
import com.gupao.edu.user.dal.entity.User;
import com.gupao.edu.user.dto.UserRequest;
import com.gupao.edu.user.dto.UserResponse;
import com.gupao.edu.user.event.RegistryEvent;
import com.gupao.edu.user.service.IUserRegistryService;
import com.gupao.edu.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/1/4
 */
@Service("userRegistryService")
public class IUserRegistryServiceImpl implements IUserRegistryService {

    @Autowired
    private IUserService userService;

    @Autowired
    private ApplicationContext applicationContext;

    @Async
    @Override
    public BaseResponse registry(UserRequest userRequest) {
        UserResponse userResponse = new UserResponse();
        if (validateParam(userRequest)) {
            return userResponse.fail();
        }
        //存储到数据库中
        BaseResponse<User> insertResponse = userService.insert(userRequest);
        if (insertResponse.isSuccess()) {
            //使用Spring的事件通知机制 通知实现类为 :RegistryEventListener
            RegistryEvent registryEvent = new RegistryEvent(insertResponse.getResult());
            applicationContext.publishEvent(registryEvent);
        } else {
            userResponse.fail();
        }
        return userResponse;
    }

    private boolean validateParam(UserRequest userRequest) {

        if (userRequest == null) {
            return false;
        }
        return true;

    }
}
