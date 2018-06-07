package com.neo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.neo.bo.SysSchedule;
import com.neo.dao.SysScheduleMapper;
import com.neo.service.TranssactionSevice;
@Service("TranssactionSeviceImpl2")
public class TranssactionSeviceImpl2 implements TranssactionSevice {
    @Autowired
    SysScheduleMapper sysScheduleMapper;
    
    /**
     * 更新状态
     */
    @Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void updateScheduleInfo(SysSchedule schedule) {
    	
	}
    @Transactional(propagation=Propagation.NOT_SUPPORTED)
    @Override
    public void errorMethod(){
    	SysSchedule  schedule=new  SysSchedule();
    	schedule.setId(2);
    	schedule.setFlag("2");
		sysScheduleMapper.updateByPrimaryKeySelective(schedule);
    }
}
