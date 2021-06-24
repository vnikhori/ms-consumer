package com.poc.consumer.msconsumer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.poc.consumer.msconsumer.model.data.DataStore;

public interface ConsumerRepository extends MongoRepository<DataStore, Integer> {

}
