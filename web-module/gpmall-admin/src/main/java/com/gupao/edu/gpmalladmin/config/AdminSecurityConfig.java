package com.gupao.edu.gpmalladmin.config;


import com.gupao.edu.gpmalladmin.handler.Securityhandler;
import com.gupao.edu.gpmalladmin.metadata.ReqeustFilterSecurityMetadataSource;
import com.gupao.edu.gpmalladmin.properties.SecurityConfProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * 权限配置设置
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityConfProperties securityProperties;

    @Autowired
    private Securityhandler successHandler;

    @Autowired
    private ReqeustFilterSecurityMetadataSource reqeustFilterSecurityMetadataSource;

    @Autowired
    private UserDetailsService customUserDetailsService;

    @Bean
    public UserDetailsService userDetailsService() {
        return customUserDetailsService;
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
        http.authorizeRequests()  // 定义哪些URL需要被保护、哪些不需要被保护
                .antMatchers(
                        "/favicon.ico",
                        "/webjars/**",
                        "/swagger-resources/**",
                        "/*/api-docs",
                        "/login**",
                        "/v/**",
                        "/v2/**"
                ).permitAll()
                .anyRequest().authenticated() //任意请求，登录之后才能进行访问
                .and()
                .formLogin()
                .loginPage("/login.html")
                .defaultSuccessUrl("/index.html")
                // .failureUrl("/login.html?error")
                .permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login.html")
                .permitAll()
        ;
       // http.addFilterBefore(definedFilterSecurityInterceptor, FilterSecurityInterceptor.class);
        http.cors().disable();
        http.headers().frameOptions().sameOrigin();
        http.csrf().disable();          // 关闭csrf防护
    }

    /**
     * 放行 静态资源文件
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/common/**", "/module/**", "/**/favicon.ico", "/larryms/**");
    }


    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("admin"));
    }

}
