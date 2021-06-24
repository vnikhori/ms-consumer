package com.poc.consumer.msconsumer.resources;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class MSConsumer {	
	
	
	@Scheduled(cron = "0 0/1 * 1/1 * ? *")	
	public void startScheduler() {
		
		System.out.println("test");

	}

}
