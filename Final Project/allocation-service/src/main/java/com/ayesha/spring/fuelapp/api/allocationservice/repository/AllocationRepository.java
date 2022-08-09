package com.ayesha.spring.fuelapp.api.allocationservice.repository;

import com.ayesha.spring.fuelapp.api.models.Allocated_Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AllocationRepository extends MongoRepository<Allocated_Stock,String> {

}
