package com.poc.consumer.msconsumer.service;

import java.util.List;
import java.util.stream.Collectors;

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
	
	/**
	 * Get the completed confirmation and then save it to master data store
	 */
	public void processData() {		
		List<Confirmation> confirmations = confirmationRepo.findConfirmationByStatus("COMPLETED");		
		List<DataStore> data = consumerRepo.findAll();
		List<String> ids = data.stream().map(e -> e.getId()).collect(Collectors.toList());
		for(Confirmation confirmation:confirmations) {
			DataStore store = createDataStore(confirmation);			
			if(ids.isEmpty()) {
				consumerRepo.save(store);	
			}
			else if(!ids.contains(confirmation.getId())) {					
				consumerRepo.save(store);				
			}		
			
		}
		
	}


	private DataStore createDataStore(Confirmation confirmation) {
		DataStore store = new DataStore();
		store.setCollectionUpdatedDateTime(confirmation.getCollectionUpdatedDateTime());
		store.setConfirmationDateTime(confirmation.getConfirmationDateTime());
		store.setConfStatus(confirmation.getConfStatus());
		store.setId(confirmation.getId());
		store.setMessageDesc(confirmation.getMessageDesc());
		store.setMessageStatusDateTime(confirmation.getMessageStatusDateTime());
		store.setOriginalValueDate(confirmation.getOriginalValueDate());
		store.setOptionalFields(confirmation.getOptionalFields());
		store.setOrigPaymentAmount(confirmation.getOrigPaymentAmount());
		store.setPaymentAmount(confirmation.getPaymentAmount());
		store.setRequestDateTime(confirmation.getRequestDateTime());
		store.setRequestMessageId(confirmation.getRequestMessageId());
		return store;
	}

}
