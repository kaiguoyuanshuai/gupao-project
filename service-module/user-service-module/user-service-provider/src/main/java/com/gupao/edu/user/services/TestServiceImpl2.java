package com.gupao.edu.user.services;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/12/20
 */

import com.gupao.edu.user.dal.entity.User;
import com.gupao.edu.user.dal.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

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
}
