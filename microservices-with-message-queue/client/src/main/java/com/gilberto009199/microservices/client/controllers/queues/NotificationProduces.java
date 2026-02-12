package com.gilberto009199.microservices.client.controllers.queues;

import com.gilberto009199.microservices.client.requests.NotificationRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.gilberto009199.microservices.client.config.KafkaConfig.topicName;


@Service
public class NotificationProduces {

    @Autowired
    private KafkaTemplate<String, NotificationRequest> topic;

    public void sendNotification(NotificationRequest notificationRequest){
        topic.send(topicName, notificationRequest);
    }

}
