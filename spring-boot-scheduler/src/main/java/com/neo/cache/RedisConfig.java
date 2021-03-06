package com.neo.cache;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import com.neo.util.TopicEnum;

@Configuration
public class RedisConfig {
    @Bean
	RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
            MessageListenerAdapter listenerAdapter){
    	RedisMessageListenerContainer  container=new RedisMessageListenerContainer();
    	container.setConnectionFactory(connectionFactory);
    	List<PatternTopic> list=new ArrayList<PatternTopic>();
    	list.add(new PatternTopic(TopicEnum.UPDATE_SCHEDULE_FLAG_TOPIC.getState()));
    	list.add(new PatternTopic("chat2"));
    	list.add(new PatternTopic("chat3"));
    	container.addMessageListener(listenerAdapter, list);
    	return container;
	}
    @Bean
    MessageListenerAdapter listenerAdapter(MessageReceiver  receiver){
    	//这个地方 是给messageListenerAdapter 传入一个消息接受的处理器，利用反射的方法调用“receiveMessage”
        //也有好几个重载方法，这边默认调用处理器的方法 叫handleMessage 可以自己到源码里面看
    	return  new MessageListenerAdapter(receiver,"receiveMessage");
    }
    /**redis 读取内容的template */
    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }
}
