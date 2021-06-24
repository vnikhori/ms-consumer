package com.poc.consumer.msconsumer.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.consumer.msconsumer.model.data.DataStore;
import com.poc.consumer.msconsumer.repository.ConfirmationRepository;
import com.poc.consumer.msconsumer.repository.ConsumerRepository;
import com.poc.consumer.msconsumer.service.ConsumerService;

@RestController
public class MSConsumerController {
	
	@Autowired
	private ConsumerService service;	
	
	@Autowired
	private ConsumerRepository consumerRepo;
	
	@Autowired
	private ConfirmationRepository confirmationRepo;
	
	@GetMapping("/process")
	public void processConfirmation() {
		service.processData();			
	}
	
	
	@GetMapping("/getData")
	public List<DataStore> getData() {
		return consumerRepo.findAll();			
	}
	
	@GetMapping("/getMessage")
	public String getMessageToShow() {
		return "show message";			
	}
	
	@DeleteMapping("/deleteData")
	public void deleteData() {
		 consumerRepo.deleteAll();			
	}
	

}
