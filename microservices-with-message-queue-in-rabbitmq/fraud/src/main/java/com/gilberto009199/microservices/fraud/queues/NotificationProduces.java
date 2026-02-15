package com.gilberto009199.microservices.fraud.queues;


import com.gilberto009199.microservices.fraud.config.RabbitMQConfig;
import com.gilberto009199.microservices.fraud.mapper.NotificationMapper;
import com.gilberto009199.microservices.topics.NotificationTopics;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NotificationProduces {

    private RabbitTemplate rabbitTemplate;
    private NotificationMapper mapper;

    public NotificationProduces(
            RabbitTemplate rabbitTemplate,
            NotificationMapper mapper
    ){
        this.rabbitTemplate = rabbitTemplate;
        this.mapper = mapper;
    }

    public void sendNotification(NotificationTopics notificationRequest){

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_USER_NOTIFICATION,
                RabbitMQConfig.ROUTING_KEY_USER_ALL,
                mapper.toJSON(notificationRequest)
        );
    }



}