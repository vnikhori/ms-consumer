package com.poc.consumer.msconsumer.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.poc.consumer.msconsumer.service.ConsumerService;

@Component
@Configuration
public class MSConsumer {	
	
	@Autowired
	private ConsumerService service;
	
	
	@Scheduled(fixedDelay = 60000)
	public void startScheduler() {
		System.out.println("starting......");
		service.processData();
		System.out.println("finished......");

	}
	
	

}
