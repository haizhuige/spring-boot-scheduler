package com.neo.rabbitMQ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**
 * 配置topic交换机类型接收方法
 * @author HuLiush
 *
 */
@Component  
@RabbitListener(bindings=@QueueBinding(key="topic.#", exchange = @Exchange(value="topicExchange",type =ExchangeTypes.TOPIC, durable = "true"), value = @Queue(value="fanout.A", durable = "true")))
public class FanoutReceiverA {
	 protected static Logger logger=LoggerFactory.getLogger(FanoutReceiverA.class);   
     
	    @RabbitHandler  
	    public void process(String message) {  
	        logger.info("fanout Receiver A  : " + message);  
	    }  
}
