package com.example.poc.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

//custom binding interface
public interface Hotel {

	@Input("inboundorders") // custom channel name
	SubscribableChannel orders();
	
	@Output("outboundhotdrinks")
	MessageChannel hotDrinks();
	
	@Output("outboundcolddrinks") 
	MessageChannel coldDrinks(); 
}
