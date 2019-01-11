package com.gupao.edu.base.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.ids.DeleteByIdsMapper;
import tk.mybatis.mapper.common.ids.SelectByIdsMapper;

/**
 * 支持单表CURD和批量(MYSQL)操作的通用Mapper
 * Created by zhengkk19738 on 2018/3/29.
 */
public interface CommonMapper<T> extends Mapper<T>, MySqlMapper<T>, SelectByIdsMapper<T>, DeleteByIdsMapper<T> {

}
