package com.neo.dao;

import com.neo.bo.SysOperatorLog;

public interface SysOperatorLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysOperatorLog record);

    int insertSelective(SysOperatorLog record);

    SysOperatorLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysOperatorLog record);

    int updateByPrimaryKey(SysOperatorLog record);
}