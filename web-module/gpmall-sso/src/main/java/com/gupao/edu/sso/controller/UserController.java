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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


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
    public ResponseData test(String time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try { //"2018-11-1 17:10:27"
            Date parse = simpleDateFormat.parse(time);

            for (int i = 0; i <100 ; i++) {
                delayTaskProcess.put(new JobDetail("test", "wobushiceshi", parse.getTime(), parse));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // kafkaTemplate.send("test", "valuesss");

        return null;
    }


}
