package com.gilberto009199.microservices.fraud.controllers;

import com.gilberto009199.microservices.fraud.responses.FraudResponse;
import com.gilberto009199.microservices.fraud.services.FraudService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud")
public class FraudController {

    private final FraudService fraudService;

    public FraudController(FraudService fraudService){
        this.fraudService = fraudService;
    }

    @PostMapping(path = "{idClient}")
    public ResponseEntity<FraudResponse> isFraudster(
        @PathVariable("idClient") Long idClient
    ){
        var isFraud = fraudService.isFraud(idClient);
        var response = new FraudResponse(isFraud);

        return ResponseEntity.ok(response);

    }
}