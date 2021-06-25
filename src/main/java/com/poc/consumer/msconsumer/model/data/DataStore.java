package com.poc.consumer.msconsumer.model.data;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "datastore")
public class DataStore {		
	@Id
	private String id;
	private String requestDateTime;
	private String requestMessageId;
	private String collectionUpdatedDateTime;
	private String confStatus;
	private String confirmationDateTime;
	private String messageDesc;
	private String messageStatusDateTime;
	private String optionalFields;
	private String origPaymentAmount;
	private String originalValueDate;
	private String paymentAmount;
}
