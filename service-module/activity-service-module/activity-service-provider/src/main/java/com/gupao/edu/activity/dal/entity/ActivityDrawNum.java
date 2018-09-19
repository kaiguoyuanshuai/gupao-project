package com.gupao.edu.activity.dal.entity;

import java.util.Date;

public class ActivityDrawNum {
    /**
     * <pre>
     * 
     * 表字段： activity_draw_num.id
     * </pre>
     * 
     */
    private Integer id;

    /**
     * <pre>
     * 
     * 表字段： activity_draw_num.uid
     * </pre>
     * 
     */
    private Integer uid;

    /**
     * <pre>
     * 
     * 表字段： activity_draw_num.name
     * </pre>
     * 
     */
    private String name;

    /**
     * <pre>
     * 以抽奖次数
     * 表字段： activity_draw_num.now_number
     * </pre>
     * 
     */
    private Integer nowNumber;

    /**
     * <pre>
     * 最大抽奖次数
     * 表字段： activity_draw_num.max_number
     * </pre>
     * 
     */
    private Integer maxNumber;

    /**
     * <pre>
     * 
     * 表字段： activity_draw_num.create_time
     * </pre>
     * 
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_draw_num.id
     *
     * @return the value of activity_draw_num.id
     *
     * @mbg.generated Wed Sep 19 10:42:27 GMT+08:00 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_draw_num.id
     *
     * @param id the value for activity_draw_num.id
     *
     * @mbg.generated Wed Sep 19 10:42:27 GMT+08:00 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_draw_num.uid
     *
     * @return the value of activity_draw_num.uid
     *
     * @mbg.generated Wed Sep 19 10:42:27 GMT+08:00 2018
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_draw_num.uid
     *
     * @param uid the value for activity_draw_num.uid
     *
     * @mbg.generated Wed Sep 19 10:42:27 GMT+08:00 2018
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_draw_num.name
     *
     * @return the value of activity_draw_num.name
     *
     * @mbg.generated Wed Sep 19 10:42:27 GMT+08:00 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_draw_num.name
     *
     * @param name the value for activity_draw_num.name
     *
     * @mbg.generated Wed Sep 19 10:42:27 GMT+08:00 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_draw_num.now_number
     *
     * @return the value of activity_draw_num.now_number
     *
     * @mbg.generated Wed Sep 19 10:42:27 GMT+08:00 2018
     */
    public Integer getNowNumber() {
        return nowNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_draw_num.now_number
     *
     * @param nowNumber the value for activity_draw_num.now_number
     *
     * @mbg.generated Wed Sep 19 10:42:27 GMT+08:00 2018
     */
    public void setNowNumber(Integer nowNumber) {
        this.nowNumber = nowNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_draw_num.max_number
     *
     * @return the value of activity_draw_num.max_number
     *
     * @mbg.generated Wed Sep 19 10:42:27 GMT+08:00 2018
     */
    public Integer getMaxNumber() {
        return maxNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_draw_num.max_number
     *
     * @param maxNumber the value for activity_draw_num.max_number
     *
     * @mbg.generated Wed Sep 19 10:42:27 GMT+08:00 2018
     */
    public void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_draw_num.create_time
     *
     * @return the value of activity_draw_num.create_time
     *
     * @mbg.generated Wed Sep 19 10:42:27 GMT+08:00 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_draw_num.create_time
     *
     * @param createTime the value for activity_draw_num.create_time
     *
     * @mbg.generated Wed Sep 19 10:42:27 GMT+08:00 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}