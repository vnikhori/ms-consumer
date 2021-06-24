package com.poc.consumer.msconsumer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.poc.consumer.msconsumer.model.data.Confirmation;

public interface ConfirmationRepository extends MongoRepository<Confirmation, Integer> {

}
