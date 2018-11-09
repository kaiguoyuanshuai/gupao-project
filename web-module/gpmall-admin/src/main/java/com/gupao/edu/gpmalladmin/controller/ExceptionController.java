package com.gupao.edu.gpmalladmin.controller;

import com.gupao.edu.gpmalladmin.builder.ErrorInfoBuilder;
import com.gupao.edu.gpmalladmin.vo.ErrorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 修改默认界面内容
 * Created by zhengkk19738 on 2018/3/7.
 */
@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class ExceptionController implements ErrorController {

    /**
     * 错误信息的构建工具.
     */
    @Autowired
    private ErrorInfoBuilder errorInfoBuilder;

    /**
     * 错误信息页的路径
     */
    private final static String DEFAULT_ERROR_VIEW = "/backstage/common/error";

    /**
     * 获取错误控制器的映射路径.
     */
    @Override
    public String getErrorPath() {
        return errorInfoBuilder.getErrorProperties().getPath();
    }

    /**
     * 情况1：若预期返回类型为text/html,s则返回错误信息页(View).
     */
    @RequestMapping(produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public ModelAndView errorHtml(HttpServletRequest request) {
        return new ModelAndView(DEFAULT_ERROR_VIEW, "errorInfo", errorInfoBuilder.getErrorInfo(request));
    }

    /**
     * 情况2：其它预期类型 则返回详细的错误信息(JSON).
     */
    @RequestMapping
    @ResponseBody
    public ErrorInfo error(HttpServletRequest request) {
        return errorInfoBuilder.getErrorInfo(request);
    }

}
