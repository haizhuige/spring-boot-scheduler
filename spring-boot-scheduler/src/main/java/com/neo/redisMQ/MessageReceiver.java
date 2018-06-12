package com.neo.redisMQ;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neo.bo.SysOperatorLog;
import com.neo.dao.SysOperatorLogMapper;
import com.neo.util.FunctionIdNum;

@Component
public class MessageReceiver{
	 @Autowired
	 SysOperatorLogMapper logMapper;
	/**接收消息的方法*/
    public void receiveMessage(String message){
    		SysOperatorLog log=new SysOperatorLog();
        	log.setFunctionId(FunctionIdNum.UPDATE_SCHEDULE_FLAG.getState());
        	log.setContent("修改定时任务标识");
        	log.setCreatedBy("admin");
        	log.setCreatedTime(new Date());
            logMapper.insert(log);
            System.out.println("方法一收到一条消息："+message);
    	
    }
    /**接收消息的方法*/
    public void receiveMessage2(String message){
    	SysOperatorLog log=new SysOperatorLog();
    	log.setFunctionId(FunctionIdNum.UPDATE_SCHEDULE_FLAG.getState());
    	log.setContent("修改定时任务标识");
    	log.setCreatedBy("admin");
    	log.setCreatedTime(new Date());
        logMapper.insert(log);
        System.out.println("方法二收到一条消息："+message);
      }
}
