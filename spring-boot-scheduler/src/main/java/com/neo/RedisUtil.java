package com.neo;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {
	@Autowired
	private	RedisTemplate<Object,Object>  template;
	
	public boolean setScheduler(final String key, Object value) {  
        boolean result = false;  
        try {  
            ValueOperations<Object, Object> operations = template.opsForValue();  
            return operations.setIfAbsent(key, value); 
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return result;  
    } 
	/**
     * 缓存字符串
     * @param key
     * @param value
     */
	public void put(String key,Object value){
		template.opsForValue().set(key, value);
	}
	/**
     * 获取缓存字符串
     * @param key
     * @param value
     */
	public Object get(String key){
		return template.opsForValue().get(key);
	}
	 /**
     * 单条字符串key删除
     * @param key
     */
    public void delKey(String key){
    	template.delete(key);
    }
    public void setKeyExpire(String key,int expire){
    	template.expire(key,expire, TimeUnit.SECONDS);
    }
    public void sendMessage(String channel, String message) {
    	template.convertAndSend(channel, message);
    }
}
