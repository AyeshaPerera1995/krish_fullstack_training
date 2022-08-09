package com.ayesha.spring.fuelapp.api.scheduleservice.service;

import com.ayesha.spring.fuelapp.api.models.Order;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ScheduleService {

    Order save(Order order);

    Order findById(String id);

    List<Order> findAll();

    Order updateOrderDateAndStatus(String id, String date);

}
