package com.gupao.edu.user.enums;

import com.gupao.edu.exceptions.enums.BaseEnum;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public enum UserResponseCodeEnum implements BaseEnum {
    USERORPASSWORD_ERRROR("001001", "用户名或密码不存在"),
    TOKEN_EXPIRE("001003", "token过期"),
    SIGNATURE_ERROR("001004", "签名验证失败"),
    SYS_PARAM_NOT_RIGHT("001002", "请求参数错误");
    private final String code;
    private final String msg;

    UserResponseCodeEnum(String code, String msg) {
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
