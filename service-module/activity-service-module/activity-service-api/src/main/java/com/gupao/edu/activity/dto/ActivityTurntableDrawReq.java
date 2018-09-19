package com.gupao.edu.activity.dto;

import com.gupao.edu.serviceext.common.dto.BaseRequest;

/*
 * 描述:
 *      活动抽奖请求参数类
 * @auth zhengkk19738
 * @time 2018/9/18
 */
public class ActivityTurntableDrawReq extends BaseRequest {

    private static final long serialVersionUID = -2656856190551500547L;
    public String uid ;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
