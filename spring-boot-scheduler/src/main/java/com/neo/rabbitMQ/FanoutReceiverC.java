package com.neo.rabbitMQ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component  
@RabbitListener(queues="fanout.C")
public class FanoutReceiverC {
	 protected static Logger logger=LoggerFactory.getLogger(FanoutReceiverC.class);   
     
	    @RabbitHandler  
	    public void process(String message) {  
	        logger.info("fanout Receiver C  : " + message);  
	    }  
}
