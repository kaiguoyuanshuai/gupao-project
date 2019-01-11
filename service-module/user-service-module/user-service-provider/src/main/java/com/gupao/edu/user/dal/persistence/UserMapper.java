package com.gupao.edu.user.dal.persistence;


import com.gupao.edu.base.mapper.CommonMapper;
import com.gupao.edu.user.dal.entity.User;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public interface UserMapper extends CommonMapper<User> {

    /**
     * @return
     */
    User getUserByUserName(String userName);


}
