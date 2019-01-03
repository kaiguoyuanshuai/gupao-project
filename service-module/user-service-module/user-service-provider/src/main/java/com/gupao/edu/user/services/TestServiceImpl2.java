package com.gupao.edu.user.services;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/12/20
 */

import com.gupao.edu.user.dal.entity.AUser;
import com.gupao.edu.user.dal.entity.User;
import com.gupao.edu.user.dal.persistence.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Service("testServiceImpl2")
public class TestServiceImpl2 {


    @Autowired
    TransactionTemplate transactionTemplate;

    @Autowired
    UserMapper userMapper;

    public boolean insert() {

        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                User user = new User();
                user.setId(1);
                user.setRealname("BBBB");
                userMapper.insertSelective(user);

                //由于某些业务判断，这里可能需要业务回滚
                status.setRollbackOnly();
                return 1;
            }
        });

        return true;

    }

    public static void te(User user, String filed) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> aClass = user.getClass();
        //Object o = aClass.newInstance();
        String methodName = "get" + StringUtils.upperCase(filed.substring(0, 1)) + filed.substring(1);
        System.out.println(methodName);

        Method method = aClass.getMethod(methodName, null);

        System.out.println(method.invoke(user, null));
    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        AUser use = new AUser();
        use.setId(1);
        use.setAa("2");
        TestServiceImpl2.te(use,"aa");
    }
}
