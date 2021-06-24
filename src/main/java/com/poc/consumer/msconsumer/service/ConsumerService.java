package com.poc.consumer.msconsumer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.consumer.msconsumer.model.data.Confirmation;
import com.poc.consumer.msconsumer.model.data.DataStore;
import com.poc.consumer.msconsumer.repository.ConfirmationRepository;
import com.poc.consumer.msconsumer.repository.ConsumerRepository;

@Service
public class ConsumerService {
	
	@Autowired
	private ConsumerRepository consumerRepo;
	
	@Autowired
	private ConfirmationRepository confirmationRepo;
	
	
	public void processData() {
		List<Confirmation> confirmations = confirmationRepo.findAll();
		List<String> ids = new ArrayList<>();		
		List<DataStore> data = consumerRepo.findAll();
		for(DataStore one:data) {
			ids.add(one.getId());
		}
		for(Confirmation confirmation:confirmations) {
			DataStore store = new DataStore(confirmation.getId(), confirmation.getRequestDateTime(), confirmation.getRequestMessageId(), confirmation.getCollectionUpdatedDateTime(), 
					confirmation.getConfStatus(), confirmation.getConfirmationDateTime(), confirmation.getMessageDesc(), confirmation.getMessageStatusDateTime(), confirmation.getOptionalFields(),
					confirmation.getOrigPaymentAmount(), confirmation.getOriginalValueDate(), confirmation.getPaymentAmount());
			
			if(ids!=null && ids.size()>0) {
				if(!ids.contains(confirmation.getId())) {
					consumerRepo.save(store);
				}
			}else {
				consumerRepo.save(store);
			}			
			
		}
		
	}

}
