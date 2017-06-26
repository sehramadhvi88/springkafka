package com.example.poc.controller;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Controller;


@EnableBinding(ConsumerChannel.class)
@Controller
public class ConsumerController {

	@StreamListener("controllerMessage")
	public void receiveGreeting(Message message){
		System.out.println("consumer controller");  
		System.out.println(message.getPayload()); 
	}
	
	@StreamListener("controllerMessage")
	public void receiveGreeting2(Message message){
		System.out.println("consumer 2 controller");  
		System.out.println(message.getPayload() + "2"); 
	} 
}

interface ConsumerChannel{
	
	@Input("controllerMessage")
	MessageChannel consumer();
	
	@Input("controllerMessage")
	MessageChannel consumer2();
}
