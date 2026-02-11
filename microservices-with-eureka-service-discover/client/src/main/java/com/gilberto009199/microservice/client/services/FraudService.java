package com.gilberto009199.microservice.client.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "clientFraud", url = "${config.external.fraud-service.url}")
public interface FraudService {

    @PostMapping("/api/v1/fraud/{idClient}")
    FraudResponse isFraud( @PathVariable("idClient") Long idClient);

    record FraudResponse(
            boolean isFraudster
    ){}

}
