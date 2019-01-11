package com.gupao.edu.seckill.dto;

import com.gupao.edu.serviceext.common.dto.BaseRequest;

import java.util.Date;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/1/11
 */
public class SeckillRequest extends BaseRequest {

    private String seckillId;

    private String seckillUserId;

    private Date seckillTime;

    public String getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(String seckillId) {
        this.seckillId = seckillId;
    }

    public String getSeckillUserId() {
        return seckillUserId;
    }

    public void setSeckillUserId(String seckillUserId) {
        this.seckillUserId = seckillUserId;
    }

    public Date getSeckillTime() {
        return seckillTime;
    }

    public void setSeckillTime(Date seckillTime) {
        this.seckillTime = seckillTime;
    }
}
