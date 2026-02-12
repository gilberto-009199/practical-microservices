package com.gilberto009199.microservices.notification.requests;

public record NotificationRequest (
    String message,
    String email
){
}
