package com.gilberto009199.microservices.notification.queues;

import com.gilberto009199.microservices.topics.NotificationTopics;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.gilberto009199.microservices.notification.config.RabbitMQConfig.QUEUE_FRAUD_NOTIFICATION;
import static com.gilberto009199.microservices.notification.config.RabbitMQConfig.QUEUE_USER_NOTIFICATION;

@Component
public class NotificationConsumer {

    @RabbitListener(queues = {
        QUEUE_USER_NOTIFICATION,
        QUEUE_FRAUD_NOTIFICATION
    })
    public void consumeNotification(NotificationTopics notificationTopics) {

        System.out.printf("Dados recebidos: %s \n", notificationTopics.message());

    }
}
