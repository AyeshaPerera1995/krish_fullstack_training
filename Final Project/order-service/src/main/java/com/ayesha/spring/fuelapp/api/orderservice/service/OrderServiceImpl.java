package com.ayesha.spring.fuelapp.api.orderservice.service;

import com.ayesha.spring.fuelapp.api.models.Order;
import com.ayesha.spring.fuelapp.api.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
            return orderRepository.save(order);
    }

    @Override
    public Order findById(String id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent())
            return order.get();
        else
            return new Order();
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public String checkOrderStatus(String id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent())
            return order.get().getStatus();
        else
            return "No any Order exist from this Reference Id !";
    }



}
