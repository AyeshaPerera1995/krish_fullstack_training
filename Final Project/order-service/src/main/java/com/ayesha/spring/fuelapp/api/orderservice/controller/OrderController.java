package com.ayesha.spring.fuelapp.api.orderservice.controller;

import com.ayesha.spring.fuelapp.api.models.Order;
import com.ayesha.spring.fuelapp.api.models.OrderEvent;
import com.ayesha.spring.fuelapp.api.orderservice.kafka.OrderProducer;
import com.ayesha.spring.fuelapp.api.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order save(@RequestBody Order order){
        Order savedOrder = orderService.save(order);

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("Order Pending");
        orderEvent.setMessage("order status is in pending");
        orderEvent.setOrder(order);
        orderProducer.sendMessage(orderEvent);

        return savedOrder;
//        return "Reference Number "+order.getId()+" "+order.getStatus()+" successfully.";
    }

    @GetMapping(value = "/{id}")
    public Order findById(@PathVariable String id){
        return orderService.findById(id);
    }

    @GetMapping
    public List<Order> findAll(){
        return orderService.findAll();
    }

    @GetMapping(value = "/status/{id}")
    public String checkOrderStatus(@PathVariable String id){
        return orderService.checkOrderStatus(id);
    }

}







