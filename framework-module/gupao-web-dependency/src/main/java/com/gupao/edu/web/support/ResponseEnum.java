package com.gupao.edu.web.support;

public enum ResponseEnum {

    SUCCESS("200","成功"),
    FAILED("500","系统繁忙,请稍后重试"),
    ;
    private String code;
    private String msg;
    private ResponseEnum(String code,String msg){
        this.msg = msg;
        this.code = code;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
