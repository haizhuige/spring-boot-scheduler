package com.neo.redisMQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

   @Autowired
   private StringRedisTemplate stringRedisTemplate;

   @Scheduled(fixedRate = 2000)
   public void sendMessage(){
	   stringRedisTemplate.convertAndSend("chat",String.valueOf(Math.random()));
   }
}
