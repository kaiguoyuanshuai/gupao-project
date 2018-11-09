package com.gupao.edu.gpmalladmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by zhengkk19738 on 2018/2/28.
 */
@Controller
public class HomeController {


    @GetMapping({"/"})
    public String root() {
        return "backstage/index";
    }


    @GetMapping({"index"})
    public String index() {
        return "backstage/index";
    }

    @GetMapping({"main"})
    public String main() {
        return "backstage/html/main";
    }


    /**
     * 跳转登录界面
     * @return
     */
    @GetMapping(value = "/login")
    public String loginPage() {
        return "html/login";
    }


}
