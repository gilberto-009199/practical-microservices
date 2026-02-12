package com.gilberto009199.microservices.notification;

import com.gilberto009199.microservices.notification.queues.NotificationConsumer;


public class NotificationController {

    private final NotificationConsumer notificationConsumer;

    public NotificationController(NotificationConsumer notificationConsumer){

        this.notificationConsumer = notificationConsumer;
    }
    


}
