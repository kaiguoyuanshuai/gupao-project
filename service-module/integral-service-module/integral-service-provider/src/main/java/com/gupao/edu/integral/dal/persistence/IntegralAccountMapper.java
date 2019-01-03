package com.gupao.edu.integral.dal.persistence;

import com.gupao.edu.integral.dal.entity.IntegralAccount;

import java.util.List;

public interface IntegralAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IntegralAccount record);

    IntegralAccount selectByPrimaryKey(Integer id);

    List<IntegralAccount> selectAll();

    int updateByPrimaryKey(IntegralAccount record);
}