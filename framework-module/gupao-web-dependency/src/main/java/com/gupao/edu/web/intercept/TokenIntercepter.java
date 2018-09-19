package com.gupao.edu.web.intercept;

import com.gupao.edu.user.dto.CheckAuthRequest;
import com.gupao.edu.user.dto.CheckAuthResponse;
import com.gupao.edu.user.service.IJsonWebTokenService;
import com.gupao.edu.web.annotations.Anoymous;
import com.gupao.edu.web.config.GpMallWebProperties;
import com.gupao.edu.web.controller.BaseController;
import com.gupao.edu.web.utils.CookieUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 用于通用的Token登录拦截
 * 作者：Administrator
 * 时间：2018/7/2
 */
public class TokenIntercepter extends HandlerInterceptorAdapter {

    private final String ACCESS_TOKEN = "access_token";

    @Autowired
    private GpMallWebProperties gpMallWebProperties;

    @Autowired
    private IJsonWebTokenService jsonWebTokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        //如果携带token信息传递，无论是否需要登录授权都应该先查询出信息设置到请求中
        //为什么呢？因为很多的业务场景下区分 如果是登录用户做什么操作，如果是非登录用户做什么操作，所以这边需要先查询出信息
        String token = CookieUtil.getCookieValue(request, ACCESS_TOKEN);
        CheckAuthResponse checkAuthResponse = null;
        boolean validate = false;
        if (StringUtils.isNotEmpty(token)) {
            CheckAuthRequest checkAuthRequest = new CheckAuthRequest();
            checkAuthRequest.setToken(token);
            checkAuthResponse = jsonWebTokenService.validateJwt(checkAuthRequest);
            if (CheckAuthResponse.SUCCESS.equals(checkAuthResponse.getCode())) {
                request.setAttribute("uid", checkAuthResponse.getUid());
                validate = true;
            }
        }

        //接下来 判断请求是否方法是否属于登录非登录用户操作

        // 如果是非登录用户操作 直接过滤

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Object bean = handlerMethod.getBean();

        if (isAnoymous(handlerMethod)) {
            return true;
        }
        if (!(bean instanceof BaseController)) {
            throw new RuntimeException("must extend BaseController");
        }
        boolean isAjax = CookieUtil.isAjax(request);
        if (StringUtils.isEmpty(token)) {
            if (isAjax) {
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().write("{\"code\":\"001003\",\"msg\":\"error\",\"url\":\"" + gpMallWebProperties.getSsoAccessUrl() + "\"}");
                return false;
            }
            response.sendRedirect(gpMallWebProperties.getSsoAccessUrl());
            return false;
        }
        // 如果是登录用户操作

        //判断是否拥有登录信息

        if (validate) {
            return super.preHandle(request, response, handler);
        }

        //如果没有登录信息，则根据请求跳转或者返回请求
        if (isAjax) {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("{\"code\":\"" + checkAuthResponse.getCode() + "\"" +
                    ",\"msg\":\"" + checkAuthResponse.getMsg() + "\",\"url\":\"" + gpMallWebProperties.getSsoAccessUrl() + "\"}");
            return false;
        }
        response.sendRedirect(gpMallWebProperties.getSsoAccessUrl());
        return false;
    }

    /**
     * 判断是否不需要登录的请求
     *
     * @param handlerMethod
     * @return
     */
    private boolean isAnoymous(HandlerMethod handlerMethod) {
        Object bean = handlerMethod.getBean();
        Class clazz = bean.getClass();
        if (clazz.getAnnotation(Anoymous.class) != null) {
            return true;
        }
        Method method = handlerMethod.getMethod();
        return method.getAnnotation(Anoymous.class) != null;
    }
}
