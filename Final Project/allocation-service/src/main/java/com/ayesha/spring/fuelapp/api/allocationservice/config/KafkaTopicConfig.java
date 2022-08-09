package com.ayesha.spring.fuelapp.api.allocationservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("topic_schedule")
    private String topicName1;

    //spring bean for kafka topics
    @Bean
    public NewTopic topic1(){
        return TopicBuilder.name(topicName1)
//                .partitions(3)
                .build();
    }


}
