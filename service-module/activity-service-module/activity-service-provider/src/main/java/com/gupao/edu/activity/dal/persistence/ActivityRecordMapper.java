package com.gupao.edu.activity.dal.persistence;


import com.gupao.edu.activity.dal.entity.ActivityRecord;

import java.util.List;

public interface ActivityRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ActivityRecord record);

    ActivityRecord selectByPrimaryKey(Integer id);

    List<ActivityRecord> selectAll();

    int updateByPrimaryKey(ActivityRecord record);
}