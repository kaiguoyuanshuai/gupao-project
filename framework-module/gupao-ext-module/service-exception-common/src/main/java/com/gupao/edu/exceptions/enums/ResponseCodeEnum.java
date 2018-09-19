package com.gupao.edu.exceptions.enums;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public enum ResponseCodeEnum implements BaseEnum {
    SUCCESS("000000", "請求成功"),
    SYSTEM_BUSY("001099", "系统繁忙，请稍候重试"),
    SYS_PARAM_NOT_RIGHT("001002", "请求参数错误"),
    FAIL("999999", "系統錯誤");

    private final String code;
    private final String msg;

    ResponseCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
