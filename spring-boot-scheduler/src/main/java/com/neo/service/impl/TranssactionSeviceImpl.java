package com.neo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.neo.bo.SysSchedule;
import com.neo.dao.SysScheduleMapper;
import com.neo.service.TranssactionSevice;
import com.neo.util.TopicEnum;
@Service("TranssactionSeviceImpl")
public class TranssactionSeviceImpl implements TranssactionSevice {
    @Autowired
    SysScheduleMapper sysScheduleMapper;
    @Autowired
    @Qualifier("TranssactionSeviceImpl2")
    TranssactionSevice transsactionSevice;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    /**
     * 更新状态
     */
    @Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void updateScheduleInfo(SysSchedule schedule) {
		sysScheduleMapper.updateByPrimaryKeySelective(schedule);
	//	transsactionSevice.errorMethod();
		stringRedisTemplate.convertAndSend(TopicEnum.UPDATE_SCHEDULE_FLAG_TOPIC.getState(),"修改定时任务标识符状态");
	 	
	}
	@Override
	public void errorMethod() {
		
	}

}
