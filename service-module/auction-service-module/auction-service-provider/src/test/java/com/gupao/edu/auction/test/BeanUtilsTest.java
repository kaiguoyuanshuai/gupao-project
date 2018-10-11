package com.gupao.edu.auction.test;

import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/10/11
 */
public class BeanUtilsTest {

    private User user;

    private UserBean userBean;


    @Before
    public void before() {
        user = new User();
        user.setName("name");
        user.setNameStrTime(new Date());
        user.setNameTime(new Date());
        user.setAge(10);

        userBean = new UserBean();
        userBean.setName("name");
        userBean.setNameStrTime("2018年10月11日14:06:34");
        userBean.setNameTime(null);
        userBean.setAge(10);
    }

    @Test
    public void copyProperties1() {
        userBean = new UserBean();
        BeanUtils.copyProperties(user, userBean);
        System.out.println(userBean.toString());
    }

    @Test
    public void copyProperties2() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        userBean = new UserBean();
        PropertyUtils.copyProperties(user, userBean);
        System.out.println(userBean.toString());
    }

    @Test
    public void copyProperties3() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        user = new User();
        BeanUtils.copyProperties(userBean, user);
        System.out.println(user.toString());
    }


    @Test
    public void copyProperties4() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        user = new User();
        org.apache.commons.beanutils.BeanUtils.copyProperties(userBean, user);
        System.out.println(user.toString());
    }
}
