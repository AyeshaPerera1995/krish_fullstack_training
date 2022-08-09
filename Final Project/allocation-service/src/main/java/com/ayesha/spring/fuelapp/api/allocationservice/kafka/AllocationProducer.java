package com.ayesha.spring.fuelapp.api.allocationservice.kafka;

import com.ayesha.spring.fuelapp.api.models.AllocationEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class AllocationProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(AllocationProducer.class);

    private NewTopic topic;

    private KafkaTemplate<String, AllocationEvent> kafkaTemplate;

    public AllocationProducer(NewTopic topic, KafkaTemplate<String, AllocationEvent> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public  void sendMessage(AllocationEvent event){
        LOGGER.info(String.format("Allocation event Producer=> %s",event.toString()));

        //create message
        Message<AllocationEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, "topic_schedule")
                .build();

        kafkaTemplate.send(message);

    }
}
