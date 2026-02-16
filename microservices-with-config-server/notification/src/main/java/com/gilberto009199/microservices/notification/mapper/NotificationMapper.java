package com.gilberto009199.microservices.notification.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gilberto009199.microservices.topics.NotificationTopics;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class NotificationMapper {

    private ObjectMapper mapper;

    public NotificationMapper(ObjectMapper mapper){
        this.mapper = mapper;
    }

    public NotificationTopics JSONToObject(String notification){
        try {

            return mapper.readValue(notification, NotificationTopics.class);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter JSON para objeto", e);
        }
    }

}
