package com.gupao.edu.delay.task.enums;

import com.gupao.edu.exceptions.enums.BaseEnum;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public enum DelayTaskErrorCodeEnum implements BaseEnum {
    PPARAM_ILLEGAL_("400001", "任务参数不能为空"),
    FAIL("999999", "系統錯誤");

    private final String code;
    private final String msg;

    DelayTaskErrorCodeEnum(String code, String msg) {
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
