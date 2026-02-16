package com.gilberto009199.microservices.fraud.repositories;

import com.gilberto009199.microservices.fraud.entities.FraudEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudRepository extends JpaRepository<FraudEntity, Long> {}
