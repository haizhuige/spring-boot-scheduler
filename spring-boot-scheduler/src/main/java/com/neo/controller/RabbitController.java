package com.neo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.rabbitMQ.RabbitSender;
import com.rabbitmq.client.AMQP.Queue;

@RestController
public class RabbitController {
 @Autowired  
 private RabbitSender fanoutSender;  
   
 @RequestMapping("/send")  
 public String send() {  
     fanoutSender.send();  
     return "send ok";  
 }  
 @RequestMapping("/topicSend")  
 public String topicSend() {  
     fanoutSender.topicSend();  
     return "send ok";  
 }  
 @RequestMapping("/directSend")  
 public String directSend() {  
     fanoutSender.directSend();  
     return "send ok";  
 }  
}
