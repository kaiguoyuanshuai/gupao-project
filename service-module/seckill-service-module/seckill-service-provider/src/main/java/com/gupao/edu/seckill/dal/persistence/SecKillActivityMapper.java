package com.gupao.edu.seckill.dal.persistence;

import com.gupao.edu.base.mapper.CommonMapper;
import com.gupao.edu.seckill.vo.SecKillActivity;

import java.util.List;

public interface SecKillActivityMapper extends CommonMapper<SecKillActivity> {
    int deleteByPrimaryKey(Integer id);

    int insert(SecKillActivity record);

    SecKillActivity selectByPrimaryKey(Integer id);

    List<SecKillActivity> selectAll();

    int updateByPrimaryKey(SecKillActivity record);
}