package com.gilberto009199.microservice.client.services;

import com.gilberto009199.microservice.client.entities.ClientEntity;
import com.gilberto009199.microservice.client.requests.ClientRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ClientService {

    private static final Logger log = LoggerFactory.getLogger(ClientService.class);

    public ClientEntity createClient(ClientRequest clientRequest){
        log.info("create client in service {}", clientRequest);

        var clientEntity = new ClientEntity();

        clientEntity.setId(Math.round(Math.random() / 0.001));
        clientEntity.setName(clientRequest.name());
        clientEntity.setEmail(clientRequest.email());

        return clientEntity;
    }

}
