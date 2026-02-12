package com.gilberto009199.microservices.fraud.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;


@Configuration
public class KafkaConfig {

    public static final String topicName = "fraud-notification";

    @Bean
    NewTopic userNotificationTopic() {
        return TopicBuilder
                .name(topicName)
                .build();
    }

}
