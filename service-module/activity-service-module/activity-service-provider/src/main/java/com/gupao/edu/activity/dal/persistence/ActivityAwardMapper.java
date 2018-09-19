package com.gupao.edu.activity.dal.persistence;


import com.gupao.edu.activity.dal.entity.ActivityAward;

import java.util.List;

public interface ActivityAwardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ActivityAward record);

    ActivityAward selectByPrimaryKey(Integer id);

    List<ActivityAward> selectAll();

    int updateByPrimaryKey(ActivityAward record);
}