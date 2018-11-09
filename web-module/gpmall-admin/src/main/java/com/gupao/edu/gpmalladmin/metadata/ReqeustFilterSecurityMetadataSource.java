package com.gupao.edu.gpmalladmin.metadata;


import com.gupao.edu.authorize.metadata.AuthType;
import com.gupao.edu.authorize.provider.service.AuthorityService;
import com.gupao.edu.authorize.vo.AuthDetailBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


/**
 * 功能说明：<br/>
 * 获取一个请求(URL)资源需要的权限
 * </br>
 * 开发人员：liuj(liuja1@strongit.com.cn)<br/>
 * 开发时间：2015年2月11日<br/>
 */

@Component
public class ReqeustFilterSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReqeustFilterSecurityMetadataSource.class);

    @Autowired
    private AuthorityService authorityService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) {
        HttpServletRequest request = ((FilterInvocation) object).getRequest();

        Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();

        //获取一个请求路径对应的权限编码，用于与用户拥有的权限编码比较，如果一致才能进行访问
        List<AuthDetailBean> pageAuthDetailInfos = authorityService.getAuthDetailByType(AuthType.PAGE);
        if (!CollectionUtils.isEmpty(pageAuthDetailInfos)) {
            for (AuthDetailBean authDetail : pageAuthDetailInfos) {
                AntPathRequestMatcher matcher = new AntPathRequestMatcher(authDetail.getExpression());

                if (matcher.matches(request)) {
                    configAttributes.add(new SecurityConfig(authDetail.getAuthCode()));
                }
            }

            if (configAttributes.isEmpty()) {
                LOGGER.info("请求路径：{},未配置权限策略，请检查，如果配置了允许匿名访问，可忽略此提示", request.getServletPath());
            } else {
                LOGGER.info("请求路径：{},需要的权限编码：{}", request.getServletPath(), Arrays.toString(configAttributes.toArray()));
            }
        }
        return configAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return Collections.emptyList();
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
