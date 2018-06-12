package com.neo.rabbitMQ;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.BindingBuilder.DirectExchangeRoutingKeyConfigurer;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange; 

@Configuration
public class FanoutRabbitConfig {
	   @Bean  
	    public Queue AMessage() {  
	        return new Queue("fanout.A");  
	    }  
	  
	    @Bean  
	    public Queue BMessage() {  
	        return new Queue("fanout.B");  
	    }  
	  
	    @Bean  
	    public Queue CMessage() {  
	        return new Queue("fanout.C");  
	    }  
	    @Bean  
	    public Queue DMessage() {  
	        return new Queue("direct.D");  
	    }  
	    @Bean  
	    FanoutExchange fanoutExchange() {  
	        return new FanoutExchange("fanoutExchange");  
	    }
	    @Bean
	    DirectExchange directExchange(){
	    	DirectExchange directExchange=new DirectExchange("directExchange", true, false);
			return directExchange;
	    	
	    }
	    @Bean
	    TopicExchange topicExchange(){
	    	TopicExchange topicExchange=new TopicExchange("topicExchange",true,false);
			return topicExchange;
	    	
	    }
	    @Bean  
	    Binding bindingExchangeA(Queue AMessage,FanoutExchange fanoutExchange) {  
	        return BindingBuilder.bind(AMessage).to(fanoutExchange);  
	    }  
	    @Bean  
	    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {  
	        return BindingBuilder.bind(BMessage).to(fanoutExchange);  
	    }  
	  
	    @Bean  
	    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {  
	        return BindingBuilder.bind(CMessage).to(fanoutExchange);  
	    } 
	    @Bean  
	    DirectExchangeRoutingKeyConfigurer bindingExchangeD(Queue DMessage, DirectExchange directExchange) {  
	        return BindingBuilder.bind(DMessage).to(directExchange);  
	    }  
}
