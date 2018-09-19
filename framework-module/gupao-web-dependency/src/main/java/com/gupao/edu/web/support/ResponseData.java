package com.gupao.edu.web.support;


public class ResponseData {

    private String code;

    private String message;

    private Object data;

    public ResponseData() {

    }

    public ResponseData(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseData(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功
     *
     * @return
     */
    public static ResponseData SUCCESS() {
        return new ResponseData(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg());
    }


    /**
     * 成功
     *
     * @return
     */
    public static ResponseData SUCCESS(Object data) {
        return new ResponseData(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg(), data);
    }


    /**
     * 失败
     *
     * @return
     */
    public static ResponseData FAILED() {
        return new ResponseData(ResponseEnum.FAILED.getCode(), ResponseEnum.FAILED.getMsg());
    }


    /**
     * 失败
     *
     * @return
     */
    public static ResponseData FAILED(Object data) {
        return new ResponseData(ResponseEnum.FAILED.getCode(), ResponseEnum.FAILED.getMsg(), data);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
