package com.neo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.neo.RedisUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by summer on 2016/12/1.
 */

@Component
public class SchedulerTask {

    @Autowired
    RedisUtil redisUtil;
    @Value("${cron.ex}")
    String cronEx;
    @Scheduled(cron="${cron.ex}")
    public void process(){
    	try {  
    		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	    String date=format.format(new Date());
            if (redisUtil.get("key") == null) {    
                if(redisUtil.setScheduler("key", "value")){  
                	redisUtil.setKeyExpire("key", 10); 
                    System.out.println("key2 "+date);
                    Thread.sleep(3000);  
                }  
            }
        } catch (InterruptedException e) {  
           
        }finally{  
          //  redisUtil.delKey("key");  
        } 
    }

}
