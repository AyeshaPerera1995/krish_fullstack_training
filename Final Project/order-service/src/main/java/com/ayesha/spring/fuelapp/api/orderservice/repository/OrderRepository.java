package com.ayesha.spring.fuelapp.api.orderservice.repository;

import com.ayesha.spring.fuelapp.api.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order,String> {

}
