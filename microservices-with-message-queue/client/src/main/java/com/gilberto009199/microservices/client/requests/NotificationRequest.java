package com.gilberto009199.microservices.client.requests;

public record NotificationRequest (
        String message,
        String email
){
}
