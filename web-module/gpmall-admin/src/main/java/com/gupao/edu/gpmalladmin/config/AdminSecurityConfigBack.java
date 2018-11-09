package com.gupao.edu.gpmalladmin.config;/*
package com.zcoco.security.config;

import Securityhandler;
import ReqeustFilterSecurityMetadataSource;
import SecurityConfProperties;
import CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import java.util.Arrays;
import java.util.List;

*/
/**
 * 权限配置设置
 *//*

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AdminSecurityConfigBack extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityConfProperties securityProperties;

    @Autowired
    private Securityhandler successHandler;

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public FilterInvocationSecurityMetadataSource reqeustFilterSecurityMetadataSource() {
        return new ReqeustFilterSecurityMetadataSource();
    }

    @Bean
    public AccessDecisionManager accessDecisionManager() {
        List<AccessDecisionVoter<? extends Object>> decisionVoters
                = Arrays.asList(
                new RoleVoter());
        return new UnanimousBased(decisionVoters);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService())
                .passwordEncoder(new BCryptPasswordEncoder())
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                // 所有 /users/signup 的POST请求 都放行
                .antMatchers("/common*/
/**").permitAll()
                .antMatchers("/module*/
/**").permitAll()
                .antMatchers("/login**").permitAll()
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login.html")
                .permitAll()
                //自定义登录之后的跳转
                .successHandler(successHandler).and()
                .authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    public <O extends FilterSecurityInterceptor> O postProcess(
                            O fsi) {
                        fsi.setSecurityMetadataSource(reqeustFilterSecurityMetadataSource());
                        fsi.setAccessDecisionManager(accessDecisionManager());
                        return fsi;
                    }
                });
    }

}
*/
