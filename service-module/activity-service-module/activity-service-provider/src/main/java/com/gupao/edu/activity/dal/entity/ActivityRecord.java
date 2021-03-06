package com.gupao.edu.activity.dal.entity;

import java.util.Date;

public class ActivityRecord {
    /**
     * <pre>
     * 
     * 表字段： activity_record.id
     * </pre>
     * 
     */
    private Integer id;

    /**
     * <pre>
     * 用户idd
     * 表字段： activity_record.uid
     * </pre>
     * 
     */
    private Integer uid;

    /**
     * <pre>
     * 
     * 表字段： activity_record.name
     * </pre>
     * 
     */
    private String name;

    /**
     * <pre>
     * 手机号
     * 表字段： activity_record.mobile
     * </pre>
     * 
     */
    private String mobile;

    /**
     * <pre>
     * 奖品登记
     * 表字段： activity_record.level
     * </pre>
     * 
     */
    private Integer level;

    /**
     * <pre>
     * 奖品名称
     * 表字段： activity_record.award_name
     * </pre>
     * 
     */
    private String awardName;

    /**
     * <pre>
     * 
     * 表字段： activity_record.create_time
     * </pre>
     * 
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_record.id
     *
     * @return the value of activity_record.id
     *
     * @mbg.generated Wed Sep 19 10:55:59 GMT+08:00 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_record.id
     *
     * @param id the value for activity_record.id
     *
     * @mbg.generated Wed Sep 19 10:55:59 GMT+08:00 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_record.uid
     *
     * @return the value of activity_record.uid
     *
     * @mbg.generated Wed Sep 19 10:55:59 GMT+08:00 2018
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_record.uid
     *
     * @param uid the value for activity_record.uid
     *
     * @mbg.generated Wed Sep 19 10:55:59 GMT+08:00 2018
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_record.name
     *
     * @return the value of activity_record.name
     *
     * @mbg.generated Wed Sep 19 10:55:59 GMT+08:00 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_record.name
     *
     * @param name the value for activity_record.name
     *
     * @mbg.generated Wed Sep 19 10:55:59 GMT+08:00 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_record.mobile
     *
     * @return the value of activity_record.mobile
     *
     * @mbg.generated Wed Sep 19 10:55:59 GMT+08:00 2018
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_record.mobile
     *
     * @param mobile the value for activity_record.mobile
     *
     * @mbg.generated Wed Sep 19 10:55:59 GMT+08:00 2018
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_record.level
     *
     * @return the value of activity_record.level
     *
     * @mbg.generated Wed Sep 19 10:55:59 GMT+08:00 2018
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_record.level
     *
     * @param level the value for activity_record.level
     *
     * @mbg.generated Wed Sep 19 10:55:59 GMT+08:00 2018
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_record.award_name
     *
     * @return the value of activity_record.award_name
     *
     * @mbg.generated Wed Sep 19 10:55:59 GMT+08:00 2018
     */
    public String getAwardName() {
        return awardName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_record.award_name
     *
     * @param awardName the value for activity_record.award_name
     *
     * @mbg.generated Wed Sep 19 10:55:59 GMT+08:00 2018
     */
    public void setAwardName(String awardName) {
        this.awardName = awardName == null ? null : awardName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity_record.create_time
     *
     * @return the value of activity_record.create_time
     *
     * @mbg.generated Wed Sep 19 10:55:59 GMT+08:00 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity_record.create_time
     *
     * @param createTime the value for activity_record.create_time
     *
     * @mbg.generated Wed Sep 19 10:55:59 GMT+08:00 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}