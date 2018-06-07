package com.neo.dao;

import org.springframework.stereotype.Repository;

import com.neo.bo.SysSchedule;
@Repository
public interface SysScheduleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysSchedule record);

    int insertSelective(SysSchedule record);

    SysSchedule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysSchedule record);

    int updateByPrimaryKey(SysSchedule record);
}