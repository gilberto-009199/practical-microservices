package com.gilberto009199.microservices.fraud.services;

import com.gilberto009199.microservices.fraud.entities.FraudEntity;
import com.gilberto009199.microservices.fraud.queues.NotificationProduces;
import com.gilberto009199.microservices.fraud.repositories.FraudRepository;
import com.gilberto009199.microservices.topics.NotificationTopics;
import org.springframework.stereotype.Service;

@Service
public class FraudService {

    private final FraudRepository fraudRepository;
    private final NotificationProduces notificationProduces;

    public FraudService(
            FraudRepository fraudRepository,
            NotificationProduces notificationProduces
    ){
        this.fraudRepository = fraudRepository;
        this.notificationProduces = notificationProduces;
    }

    public boolean isFraud(long idClient){

        var isFraud = true;

        fraudRepository.save(
                new FraudEntity()
                        .setClientId(idClient)
                        .setFraudster(isFraud)
        );

        if(isFraud) notificationProduces.sendNotification(new NotificationTopics("Fraud Detected", "admin@gilberto009199.com"));

        return isFraud;
    }

}
