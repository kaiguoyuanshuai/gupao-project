package com.gupao.edu.dubbo.controller;

import com.gupao.edu.integral.dto.ScoreOperationRequest;
import com.gupao.edu.integral.service.IntegralAccountBusinessService;
import com.gupao.edu.serviceext.common.dto.BaseResponse;
import com.gupao.edu.user.dto.UserLoginRequest;
import com.gupao.edu.user.dto.UserLoginResponse;
import com.gupao.edu.user.dto.UserRequest;
import com.gupao.edu.user.service.IUserLoginService;
import com.gupao.edu.user.service.IUserRegistryService;
import com.gupao.edu.web.annotations.Anoymous;
import com.gupao.edu.web.config.GpMallWebProperties;
import com.gupao.edu.web.controller.BaseController;
import com.gupao.edu.web.support.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.UUID;


@RestController
public class UserController extends BaseController {

    @Autowired
    private IUserLoginService userLoginService;

    @Autowired
    private IUserRegistryService userRegistryService;

    @Autowired
    private IntegralAccountBusinessService integralAccountBusinessService;

    @Autowired
    private GpMallWebProperties gpMallWebProperties;

/*
    @Autowired
    private DelayTaskProcess delayTaskProcess;

    @Autowired
    KafkaTemplate kafkaTemplate;
*/


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
    public ResponseData test(String time) {
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("name" + UUID.randomUUID());

        BaseResponse registry = userRegistryService.registry(userRequest);

        return ResponseData.SUCCESS(registry);
    }


    @RequestMapping("/de")
    @Anoymous
    public ResponseData de(String time) {
        ScoreOperationRequest scoreOperationRequest = new ScoreOperationRequest();
        scoreOperationRequest.setUserId("13957");
        scoreOperationRequest.setScore(new BigDecimal(10));
        scoreOperationRequest.setOuterBusinessCode(String.valueOf(UUID.randomUUID()));
        BaseResponse baseResponse = integralAccountBusinessService.deductionScore(scoreOperationRequest);
        return ResponseData.SUCCESS();
    }

}
