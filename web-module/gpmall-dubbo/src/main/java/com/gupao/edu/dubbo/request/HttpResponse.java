package com.gupao.edu.dubbo.request;

import java.io.Serializable;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/12/4
 */
public class HttpResponse implements Serializable {

    private static final long serialVersionUID = -552828440320737814L;
    private boolean success;
    private String code;
    private String description;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
