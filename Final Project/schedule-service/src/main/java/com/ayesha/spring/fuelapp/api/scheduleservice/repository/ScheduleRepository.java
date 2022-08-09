package com.ayesha.spring.fuelapp.api.scheduleservice.repository;

import com.ayesha.spring.fuelapp.api.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ScheduleRepository extends MongoRepository<Order,String> {


}
