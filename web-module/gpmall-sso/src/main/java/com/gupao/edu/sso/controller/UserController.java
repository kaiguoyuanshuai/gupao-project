package com.gupao.edu.sso.controller;

import com.gupao.edu.delay.task.DelayTaskProcess;
import com.gupao.edu.delay.task.job.JobDetail;
import com.gupao.edu.user.dto.UserLoginRequest;
import com.gupao.edu.user.dto.UserLoginResponse;
import com.gupao.edu.user.service.IUserLoginService;
import com.gupao.edu.web.annotations.Anoymous;
import com.gupao.edu.web.config.GpMallWebProperties;
import com.gupao.edu.web.controller.BaseController;
import com.gupao.edu.web.support.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


@RestController
public class UserController extends BaseController {

    @Autowired
    private IUserLoginService userLoginService;

    @Autowired
    private GpMallWebProperties gpMallWebProperties;

    @Autowired
    private DelayTaskProcess delayTaskProcess;

    @Autowired
    KafkaTemplate kafkaTemplate;


    @PostMapping("/login")
    @Anoymous
    public ResponseData doLogin(String username, String password, HttpServletResponse response) {
        ResponseData data = new ResponseData();
        UserLoginRequest request = new UserLoginRequest();
        request.setPassWord(password);
        request.setUserName(username);
        UserLoginResponse loginResponse = userLoginService.login(request);
        response.addHeader("Set-Cookie",
                "access_token=" + loginResponse.getToken() + ";Path=/;HttpOnly");
        data.setMessage(loginResponse.getMsg());
        data.setCode(loginResponse.getCode());
        data.setData(gpMallWebProperties.getActivityAccessUrl());
        return data;
    }

    @RequestMapping("/test")
    @Anoymous
    public ResponseData test() {
        // kafkaTemplate.send("test", "valuesss");
        delayTaskProcess.put(new JobDetail("test", "test", System.currentTimeMillis(), null));

        return null;
    }


}
