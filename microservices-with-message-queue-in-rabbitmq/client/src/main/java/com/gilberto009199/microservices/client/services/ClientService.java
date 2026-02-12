package com.gilberto009199.microservices.client.services;

import com.gilberto009199.microservices.client.queues.NotificationProduces;
import com.gilberto009199.microservices.client.entities.ClientEntity;
import com.gilberto009199.microservices.client.repositories.ClientRepository;
import com.gilberto009199.microservices.client.requests.ClientRequest;

import com.gilberto009199.microservices.topics.NotificationTopics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private static final Logger log = LoggerFactory.getLogger(ClientService.class);

    private final ClientRepository clientRepository;
    private final NotificationProduces notificationProduces;
    private final FraudService fraudService;

    public ClientService(
            ClientRepository clientRepository,
            NotificationProduces notificationProduces,
            FraudService fraudService
    ){
        this.clientRepository = clientRepository;
        this.notificationProduces = notificationProduces;
        this.fraudService = fraudService;
    }

    public ClientEntity createClient(ClientRequest clientRequest){
        log.info("create client in service {}", clientRequest);

        var clientEntity = new ClientEntity()
                .setName(clientRequest.name())
                .setEmail(clientRequest.email());



        clientRepository.saveAndFlush(clientEntity);

        fraudService.isFraud(clientEntity.getId());

        notificationProduces.sendNotification(new NotificationTopics("Create your account", clientEntity.getEmail()));

        return clientEntity;
    }

}
