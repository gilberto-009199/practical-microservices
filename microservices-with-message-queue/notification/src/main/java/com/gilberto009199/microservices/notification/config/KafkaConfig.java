package com.gilberto009199.microservices.notification.config;


import org.apache.kafka.clients.admin.NewTopic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.kafka.config.TopicBuilder;




@Configuration
public class KafkaConfig {

    public static final String topicUserNotification = "user-notification";
    public static final String topicFraudNotification = "fraud-notification";

    @Bean
    NewTopic userNotificationTopic() {
        return TopicBuilder
                .name(topicUserNotification)
                .build();
    }

    @Bean
    NewTopic fraudNotificationTopic() {
        return TopicBuilder
                .name(topicFraudNotification)
                .build();
    }

}
