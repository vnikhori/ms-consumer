package com.poc.consumer.msconsumer.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.poc.consumer.msconsumer.model.data.Confirmation;

public interface ConfirmationRepository extends MongoRepository<Confirmation, Integer> {
	
	@Query(value = "{confStatus : ?0}")
	List<Confirmation> findConfirmationByStatus(String confStatus);

}
