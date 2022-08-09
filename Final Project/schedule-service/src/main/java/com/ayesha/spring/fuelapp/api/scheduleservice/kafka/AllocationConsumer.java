package com.ayesha.spring.fuelapp.api.scheduleservice.kafka;

import com.ayesha.spring.fuelapp.api.models.AllocationEvent;
import com.ayesha.spring.fuelapp.api.scheduleservice.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AllocationConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(AllocationConsumer.class);

    private OrderRepository orderRepository;

    public AllocationConsumer(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @KafkaListener(
            topics = "${spring.kafka.topic.name}"
            ,groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(AllocationEvent event){
        LOGGER.info(String.format("Allocation event received into schedule service => %s",event.toString()));

//      SAVE DATA
//        if (event.getOrder().getStatus() == "Allocation Completed") {

        long minDay = LocalDate.of(2022, 8, 12).toEpochDay();
        long maxDay = LocalDate.of(2022, 12, 1).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);

            event.getOrder().setScheduled_date(randomDate);
            event.getOrder().setStatus("Delivery Scheduled");
            orderRepository.save(event.getOrder());
//        }

    }
}
