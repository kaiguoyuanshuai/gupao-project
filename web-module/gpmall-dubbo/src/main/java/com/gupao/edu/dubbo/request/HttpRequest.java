package com.gupao.edu.dubbo.request;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/12/4
 */
public class HttpRequest {
    private String param;

    private String service;

    private String method;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
