package com.gupao.edu.auction.test;

import java.util.Date;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/10/11
 */
public class UserBean {


    private String name ;

    private Date nameTime ;

    private String nameStrTime ;

    private Integer age ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getNameTime() {
        return nameTime;
    }

    public void setNameTime(Date nameTime) {
        this.nameTime = nameTime;
    }

    public String getNameStrTime() {
        return nameStrTime;
    }

    public void setNameStrTime(String nameStrTime) {
        this.nameStrTime = nameStrTime;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "name='" + name + '\'' +
                ", nameTime=" + nameTime +
                ", nameStrTime='" + nameStrTime + '\'' +
                ", age=" + age +
                '}';
    }
}
