package com.gilberto009199.microservices.notification.queues;

import com.gilberto009199.microservices.notification.requests.NotificationRequest;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {


    @Bean
    NewTopic userNotificationTopic() {
        return TopicBuilder.name("user-notification")
                .build();
    }

    @Bean
    NewTopic fraudNotificationTopic() {
        return TopicBuilder.name("fraud-notification")
                .build();
    }

    @KafkaListener(
            topics = {
                "user-notification",
                "fraud-notification"
            },
            groupId = "notification")
    public void consumeNotification(NotificationRequest notificationRequest){

        System.out.printf("Dados recebidos: %s \n", notificationRequest.message());

    }
}
