package com.example.poc.controller;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@EnableBinding(ProducerChannel.class)
@RestController
public class ProducerController {
	
	private final ProducerChannel producerChannel;
	
	public ProducerController(ProducerChannel producerChannel){
		this.producerChannel = producerChannel;
	}
	
	@GetMapping("/greet/{name}")
	void great(@PathVariable String name){
		String greeting = "Hello "+ name + " !";
		System.out.println("producer sending message ="+greeting);
		Message<String> message= MessageBuilder.withPayload(greeting).build();
		producerChannel.producer().send(message);
		
	}

}


interface ProducerChannel{
	
	@Output("controllerMessage")
	MessageChannel producer();
}