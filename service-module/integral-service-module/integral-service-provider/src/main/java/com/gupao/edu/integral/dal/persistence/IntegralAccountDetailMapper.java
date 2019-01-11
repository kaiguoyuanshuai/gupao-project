package com.gupao.edu.integral.dal.persistence;


import com.gupao.edu.base.mapper.CommonMapper;
import com.gupao.edu.integral.dal.entity.IntegralAccountDetail;

import java.util.List;

public interface IntegralAccountDetailMapper extends CommonMapper<IntegralAccountDetail> {
/*
    int deleteByPrimaryKey(Integer id);
*/

    int insert(IntegralAccountDetail record);

 /*   IntegralAccountDetail selectByPrimaryKey(Integer id);*/

    List<IntegralAccountDetail> selectAll();

    int updateByPrimaryKey(IntegralAccountDetail record);

    /**
     * 根据 外部流水号查询积分消费流水信息
     *
     * @param outerBusinessCode
     * @return
     */
    IntegralAccountDetail selectIntegralAccountDetailByBusineesCode(String outerBusinessCode);


}