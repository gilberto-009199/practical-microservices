package com.gilberto009199.microservices.fraud.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_USER_NOTIFICATION = "user-notification-exchange";
    public static final String QUEUE_USER_NOTIFICATION = "user-notification-queue";
    public static final String ROUTING_KEY_USER_ALL = "user.*";

    public static final String EXCHANGE_FRAUD_NOTIFICATION = "fraud-notification-exchange";
    public static final String QUEUE_FRAUD_NOTIFICATION = "fraud-notification-queue";
    public static final String ROUTING_KEY_FRAUD_ALL = "fraud.*";


    @Bean
    public TopicExchange userNotificationExchange() {
        return ExchangeBuilder
                .topicExchange(EXCHANGE_USER_NOTIFICATION)
                .durable(true)
                .build();
    }

    @Bean
    public Queue userNotificationQueue() {
        return QueueBuilder
                .durable(QUEUE_USER_NOTIFICATION)
                .build();
    }

    @Bean
    public Binding userNotificationBinding() {
        return BindingBuilder
                .bind(userNotificationQueue())
                .to(userNotificationExchange())
                .with(ROUTING_KEY_USER_ALL);
    }

    @Bean
    public TopicExchange fraudNotificationExchange() {
        return ExchangeBuilder
                .topicExchange(EXCHANGE_FRAUD_NOTIFICATION)
                .durable(true)
                .build();
    }

    @Bean
    public Queue fraudNotificationQueue() {
        return QueueBuilder
                .durable(QUEUE_FRAUD_NOTIFICATION)
                .build();
    }

    @Bean
    public Binding fraudNotificationBinding() {
        return BindingBuilder
                .bind(fraudNotificationQueue())
                .to(fraudNotificationExchange())
                .with(ROUTING_KEY_FRAUD_ALL);
    }

}
