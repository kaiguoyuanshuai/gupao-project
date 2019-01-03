package com.gupao.edu.integral.dal.persistence;

import com.gupao.edu.integral.dal.entity.IntegralAccountDetail;

import java.util.List;

public interface IntegralAccountDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IntegralAccountDetail record);

    IntegralAccountDetail selectByPrimaryKey(Integer id);

    List<IntegralAccountDetail> selectAll();

    int updateByPrimaryKey(IntegralAccountDetail record);
}