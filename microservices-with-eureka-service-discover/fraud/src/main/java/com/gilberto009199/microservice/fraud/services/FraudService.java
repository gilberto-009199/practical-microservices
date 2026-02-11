package com.gilberto009199.microservice.fraud.services;

import com.gilberto009199.microservice.fraud.entities.FraudEntity;
import com.gilberto009199.microservice.fraud.repositories.FraudRepository;
import org.springframework.stereotype.Service;

@Service
public class FraudService {

    private final FraudRepository fraudRepository;

    public FraudService(FraudRepository fraudRepository){
        this.fraudRepository = fraudRepository;
    }

    public boolean isFraud(long idClient){

        var isFraud = true;

        fraudRepository.save(
                new FraudEntity()
                        .setClientId(idClient)
                        .setFraudster(isFraud)
        );

        return isFraud;
    }

}
