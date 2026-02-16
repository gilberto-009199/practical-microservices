package com.gilberto009199.microservices.client.controllers;

import com.gilberto009199.microservices.client.entities.ClientEntity;
import com.gilberto009199.microservices.client.requests.ClientRequest;
import com.gilberto009199.microservices.client.services.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/client")
public class ClientController {

    private static final Logger log = LoggerFactory.getLogger(ClientController.class);

    private final ClientService clientService;

    public ClientController( ClientService clientService ){
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientEntity> create(@RequestBody ClientRequest clientRequest){

        log.info("new client create {}", clientRequest);

        var clientEntity = clientService.createClient(clientRequest);


        return ResponseEntity.ok(clientEntity);

    }

}
