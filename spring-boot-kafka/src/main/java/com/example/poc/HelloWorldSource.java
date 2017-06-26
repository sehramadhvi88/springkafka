package com.example.poc;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;

@EnableBinding(Source.class)
public class HelloWorldSource {
	
	@InboundChannelAdapter(channel = Source.OUTPUT)
	public String sayHello(){
		return "Hello , World !";
	}	
}
