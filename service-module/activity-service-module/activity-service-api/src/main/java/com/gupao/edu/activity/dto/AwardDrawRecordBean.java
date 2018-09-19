package com.gupao.edu.activity.dto;

import java.io.Serializable;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/9/18
 */
public class AwardDrawRecordBean implements Serializable {


    private static final long serialVersionUID = -2955188553324863847L;
    private Integer id;

    private Integer uid;

    private String name;

    private Integer level; //中奖等级

    private String mobile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
