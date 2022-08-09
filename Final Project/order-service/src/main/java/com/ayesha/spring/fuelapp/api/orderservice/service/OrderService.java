package com.ayesha.spring.fuelapp.api.orderservice.service;

import com.ayesha.spring.fuelapp.api.models.Order;

import java.util.List;

public interface OrderService {

    Order save(Order order);

    Order findById(String id);

    List<Order> findAll();

    String checkOrderStatus(String id);

//    Order setOrderStatus(String id, String status);

}
