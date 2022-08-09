package com.ayesha.spring.fuelapp.api.allocationservice.kafka;

import com.ayesha.spring.fuelapp.api.allocationservice.repository.OrderRepository;
import com.ayesha.spring.fuelapp.api.allocationservice.service.AllocationService;
import com.ayesha.spring.fuelapp.api.models.Allocated_Stock;
import com.ayesha.spring.fuelapp.api.models.AllocationEvent;
import com.ayesha.spring.fuelapp.api.models.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @Autowired
    private AllocationService allocationService;

    @Autowired
    private AllocationProducer allocationProducer;
//    public OrderConsumer(AllocationProducer allocationProducer) {
//        this.allocationProducer = allocationProducer;
//    }


    private OrderRepository orderRepository;

    public OrderConsumer(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @KafkaListener(
            topics = "${spring.kafka.topic.name}"
            ,groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(OrderEvent event){
        LOGGER.info(String.format("Order event received into allocation service => %s",event.toString()));

//      SAVE DATA

//      check the stock is available or not
        int request_fuel_capacity = event.getOrder().getFuel_capasity();
        int usable_stock = allocationService.getUsableStock(event.getOrder().getFuel_type());
        System.out.println("request_fuel_capacity: "+request_fuel_capacity);System.out.println("usable_stock: "+usable_stock);
        if (usable_stock >= request_fuel_capacity && event.getOrder().getStatus() != "Allocation Completed") {
            System.out.println("in");
//          change order status
            event.setStatus("Allocation Completed");
            event.setMessage("order status is allocation completed");
            event.getOrder().setStatus("Allocation Completed");
            orderRepository.save(event.getOrder());

//          save data to allocated_stock table
            Allocated_Stock allocated_stock = new Allocated_Stock();
            allocated_stock.setOrder_id(event.getOrder().getId());
            allocated_stock.setFuel_type(event.getOrder().getFuel_type());
            allocated_stock.setAllocated_stock(event.getOrder().getFuel_capasity());
            allocationService.save(allocated_stock);

//            Create new allocation event
            AllocationEvent allocationEvent = new AllocationEvent();
            allocationEvent.setStatus("Allocation Completed");
            allocationEvent.setMessage("order status is allocated");
            allocationEvent.setOrder(event.getOrder());
            allocationProducer.sendMessage(allocationEvent);

        }else {
            event.getOrder().setStatus("Order Cancelled");
            orderRepository.save(event.getOrder());
        }

    }
}
