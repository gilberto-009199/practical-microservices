package com.gilberto009199.microservices.client.mapper;

import com.gilberto009199.microservices.topics.NotificationTopics;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class NotificationMapper {

    private ObjectMapper mapper;

    public NotificationMapper(ObjectMapper mapper){
        this.mapper = mapper;
    }

    public String toJSON(NotificationTopics notification){
        return mapper.writeValueAsString(notification);
    }

}
