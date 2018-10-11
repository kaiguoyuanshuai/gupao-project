package com.gupao.edu.auction.test;

import java.util.Date;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/10/11
 */
public class User {

    private String name;

    private Date nameTime;

    private Date nameStrTime;

    private Integer age;

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

    public Date getNameStrTime() {
        return nameStrTime;
    }

    public void setNameStrTime(Date nameStrTime) {
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
        return "User{" +
                "name='" + name + '\'' +
                ", nameTime=" + nameTime +
                ", nameStrTime=" + nameStrTime +
                ", age='" + age + '\'' +
                '}';
    }
}
