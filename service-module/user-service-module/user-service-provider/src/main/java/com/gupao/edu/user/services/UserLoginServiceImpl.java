package com.gupao.edu.user.services;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.gupao.edu.exceptions.ExceptionUtil;
import com.gupao.edu.exceptions.ServiceException;
import com.gupao.edu.exceptions.ValidateException;
import com.gupao.edu.user.dal.entity.User;
import com.gupao.edu.user.dal.persistence.UserMapper;
import com.gupao.edu.user.dto.UserLoginRequest;
import com.gupao.edu.user.dto.UserLoginResponse;
import com.gupao.edu.user.enums.UserResponseCodeEnum;
import com.gupao.edu.user.service.IUserLoginService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gupao.edu.user.utils.JwtTokenUtils;

import java.util.HashMap;
import java.util.Map;


/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
@Service("userLoginService")
public class UserLoginServiceImpl implements IUserLoginService {

    Logger Log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserMapper userMapper;

    @Override
    public UserLoginResponse login(UserLoginRequest request) {
        Log.info("login request:" + request);
        UserLoginResponse response = new UserLoginResponse();
        try {
            beforeValidate(request);
            User user = userMapper.getUserByUserName(request.getUserName());
            if (user == null || !user.getPassword().equals(request.getPassWord())) {
                response.fail(UserResponseCodeEnum.USERORPASSWORD_ERRROR);
                return response;
            }
            Map<String,Object> map=new HashMap<>();
            map.put("uid",user.getId());
            map.put("exp", DateTime.now().plusSeconds(40).toDate().getTime()/1000);

            response.setToken(JwtTokenUtils.generatorToken(map));
            response.setUid(user.getId());
            response.setAvatar(user.getAvatar());
            response.success();
        } catch (Exception e) {
            Log.error("login occur exception :" + e);
            ServiceException serviceException = (ServiceException) ExceptionUtil.handlerException4biz(e);
            response.fail(serviceException);
        } finally {
            Log.info("login response->" + response);
        }
        return response;
    }

    private void beforeValidate(UserLoginRequest request) {
        if (request == null) {
            throw new ValidateException("请求对象为空");
        }
        if (StringUtils.isEmpty(request.getUserName())) {
            throw new ValidateException("用户名为空");
        }
        if (StringUtils.isEmpty(request.getPassWord())) {
            throw new ValidateException("密码为空");
        }
    }
}
