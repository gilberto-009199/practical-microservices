package com.gilberto009199.microservices.notification.queues;

import com.gilberto009199.microservices.topics.NotificationTopics;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

    @KafkaListener(
            topics = {
                    "user-notification",
                    "fraud-notification"
            },
            groupId = "notification")
    public void consumeNotification(NotificationTopics notificationTopics) {

        System.out.printf("Dados recebidos: %s \n", notificationTopics.message());

    }
}
