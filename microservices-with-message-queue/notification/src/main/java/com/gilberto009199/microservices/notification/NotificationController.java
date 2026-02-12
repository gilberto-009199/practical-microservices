package com.gilberto009199.microservices.notification;

import com.gilberto009199.microservices.notification.queues.NotificationConsumer;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    private final NotificationConsumer notificationConsumer;

    public NotificationController(NotificationConsumer notificationConsumer){
        System.out.println("dsdasdasdad");
        this.notificationConsumer = notificationConsumer;
    }




}
