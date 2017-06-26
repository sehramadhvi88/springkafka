package com.example.poc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;

@EnableBinding(Sink.class)
public class HelloWorldSink {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldSink.class);
	
	@ServiceActivator(inputChannel = Sink.INPUT)
	public void printMessage(final String message){
		System.out.println("in consumer");
		LOGGER.info("{}",message);
	}
	
}
