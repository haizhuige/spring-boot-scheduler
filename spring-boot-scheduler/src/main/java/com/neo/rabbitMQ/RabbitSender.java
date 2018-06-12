package com.neo.rabbitMQ;

import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitSender {
	 protected static Logger logger=LoggerFactory.getLogger(RabbitSender.class);  
	 @Autowired  
	 private AmqpTemplate rabbitTemplate;  
	  
	    public void send() {  
	        String context = "hi, fanout msg ";  
	        logger.debug("Sender : " + context);  
	        this.rabbitTemplate.convertAndSend("fanoutExchange","", context);  
	    } 
	    public void topicSend() {  
	        String context = "hi, topic msg ";  
	        logger.debug("Sender : " + context);  
	        this.rabbitTemplate.convertAndSend("topicExchange","topic.A", context);  
	    }
	    public void directSend() {  
	        String context = "hi, dirct msg ";  
	        logger.debug("Sender : " + context);  
	        this.rabbitTemplate.convertAndSend("directExchange","direct.B", context);  
	    }  
}
