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
 * direct交换机
 * @author HuLiush
 *
 */
@Component  
@RabbitListener(bindings=@QueueBinding(key="direct.B", exchange = @Exchange(value="directExchange",type =ExchangeTypes.DIRECT, durable = "true"), value = @Queue(value="direct.D", durable = "true")))
public class FanoutReceiverB {
	 protected static Logger logger=LoggerFactory.getLogger(FanoutReceiverB.class);   
     
	    @RabbitHandler  
	    public void process(String message) {  
	        logger.info("direct Receiver B  : " + message);  
	    }  
}
