package com.gupao.edu.serviceext.common.dto;

import com.gupao.edu.exceptions.ServiceException;
import com.gupao.edu.exceptions.enums.BaseEnum;
import com.gupao.edu.exceptions.enums.ResponseCodeEnum;

import java.io.Serializable;

/**
 * 服务层公共方法参数接口
 */
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 7505997295595095971L;

    public static final String SUCCESS = "000000";

    private String code;
    private String msg;

    private T result;

    /**
     * 构建成功返回
     *
     * @return BaseResponse
     */
    public BaseResponse success() {
        this.code = ResponseCodeEnum.SUCCESS.getCode();
        this.msg = ResponseCodeEnum.SUCCESS.getMsg();
        return this;
    }


    /**
     * 构建成功返回
     *
     * @param result 设置返回的对象
     */
    public BaseResponse success(T result) {
        this.code = ResponseCodeEnum.SUCCESS.getCode();
        this.msg = ResponseCodeEnum.SUCCESS.getMsg();
        this.result = result;
        return this;
    }


    /**
     * 构建失败返回
     *
     * @return
     */
    public void fail() {
        this.code = ResponseCodeEnum.FAIL.getCode();
        this.msg = ResponseCodeEnum.FAIL.getMsg();
    }


    /**
     * 构建失败返回
     *
     * @param result 设置返回的对象
     * @return
     */
    public void fail(T result) {
        this.code = ResponseCodeEnum.FAIL.getCode();
        this.msg = ResponseCodeEnum.FAIL.getMsg();
        this.result = result;
    }

    /**
     * 构建失败返回
     *
     * @param code
     * @param message
     * @return
     */
    public void fail(String code, String message) {
        this.code = code;
        this.msg = message;
    }


    /**
     * 构建失败返回
     *
     * @param code
     * @param message
     * @param t
     * @return
     */
    public void fail(String code, String message, T t) {
        this.code = code;
        this.msg = message;
        this.result = t;
    }


    /**
     * 返回消息類型
     *
     * @param messageEnums
     * @return
     */
    public void fail(BaseEnum messageEnums) {
        this.code = messageEnums.getCode();
        this.msg = messageEnums.getMsg();
    }


    /**
     * 返回消息類型
     *
     * @param messageEnums
     * @param result
     * @return
     */
    public void fail(BaseEnum messageEnums, T result) {
        this.code = messageEnums.getCode();
        this.msg = messageEnums.getMsg();
        this.result = result;
    }


    /**
     * 返回消息類型
     *
     * @param serviceException
     * @return
     */
    public void fail(ServiceException serviceException) {
        this.code = serviceException.getErrorCode();
        this.msg = serviceException.getErrorMessage();
    }

    /**
     * 返回消息類型
     *
     * @param serviceException
     * @param result
     * @return
     */
    public void fail(ServiceException serviceException, T result) {
        this.code = serviceException.getErrorCode();
        this.msg = serviceException.getErrorMessage();
        this.result = result;
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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
