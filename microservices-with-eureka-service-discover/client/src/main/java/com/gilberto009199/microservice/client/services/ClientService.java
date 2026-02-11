package com.gilberto009199.microservice.client.services;

import com.gilberto009199.microservice.client.entities.ClientEntity;
import com.gilberto009199.microservice.client.repositories.ClientRepository;
import com.gilberto009199.microservice.client.requests.ClientRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ClientService {

    private static final Logger log = LoggerFactory.getLogger(ClientService.class);

    private final ClientRepository clientRepository;
    private final FraudService fraudService;

    public ClientService(
            ClientRepository clientRepository,
            FraudService fraudService
    ){
        this.clientRepository = clientRepository;
        this.fraudService = fraudService;
    }

    public ClientEntity createClient(ClientRequest clientRequest){
        log.info("create client in service {}", clientRequest);

        var clientEntity = new ClientEntity()
                .setName(clientRequest.name())
                .setEmail(clientRequest.email());



        clientRepository.saveAndFlush(clientEntity);

        fraudService.isFraud(clientEntity.getId());



        return clientEntity;
    }

}
