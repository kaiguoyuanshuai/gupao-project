package com.gupao.edu.activity.dal.persistence;

import com.gupao.edu.activity.dal.entity.ActivityAwardItem;

import java.util.List;

public interface ActivityAwardItemMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ActivityAwardItem record);

    ActivityAwardItem selectByPrimaryKey(Integer id);

    List<ActivityAwardItem> selectAll();

    int updateByPrimaryKey(ActivityAwardItem record);
}