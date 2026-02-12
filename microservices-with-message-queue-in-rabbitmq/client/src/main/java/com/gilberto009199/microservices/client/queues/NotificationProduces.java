package com.gilberto009199.microservices.client.queues;


import com.gilberto009199.microservices.topics.NotificationTopics;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.gilberto009199.microservices.client.config.KafkaConfig.topicName;


@Service
public class NotificationProduces {

    @Autowired
    private KafkaTemplate<String, NotificationTopics> topic;

    public void sendNotification(NotificationTopics notificationRequest){
        topic.send(topicName, notificationRequest);
    }

}
