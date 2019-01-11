package com.gupao.edu.integral.dal.persistence;

import com.gupao.edu.base.mapper.CommonMapper;
import com.gupao.edu.integral.vo.IntegralAccount;

import java.util.List;

public interface IntegralAccountMapper extends CommonMapper<IntegralAccount> {
/*
    int deleteByPrimaryKey(Integer id);
*/

    int insert(IntegralAccount record);

/*    IntegralAccount selectByPrimaryKey(Integer id);*/

    List<IntegralAccount> selectAll();

    int updateByPrimaryKey(IntegralAccount record);

    /**
     * 根据用户ID查询积分账户信息
     *
     * @param userId
     * @return
     */
    IntegralAccount selectIntgralAccountInfoByUserId(Integer userId);
}