package com.gilberto009199.microservice.fraud.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_frauds")
public class FraudEntity {

    @Id
    @SequenceGenerator(
            name = "seq_tbl_frauds_id",
            sequenceName = "seq_tbl_frauds_id"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_tbl_frauds_id"
    )
    private Long id;

    @Column
    private Long clientId;
    @Column
    private boolean isFraudster;

    @Column
    @CreationTimestamp
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public FraudEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getClientId() {
        return clientId;
    }

    public FraudEntity setClientId(Long clientId) {
        this.clientId = clientId;
        return this;
    }

    public boolean isFraudster() {
        return isFraudster;
    }

    public FraudEntity setFraudster(boolean fraudster) {
        isFraudster = fraudster;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public FraudEntity setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}
