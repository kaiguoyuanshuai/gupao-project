package com.gupao.edu.activity.dal.persistence;


import com.gupao.edu.activity.dal.entity.ActivityDrawNum;

import java.util.List;

public interface ActivityDrawNumMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ActivityDrawNum record);

    ActivityDrawNum selectByPrimaryKey(Integer id);

    List<ActivityDrawNum> selectAll();

    int updateByPrimaryKey(ActivityDrawNum record);
}