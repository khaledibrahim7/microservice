package com.microservice.payment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "payment")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "transaction_id", unique = true, nullable = false)
    private String tranId ;
    @Column(name ="amount")
    private double amount ;
    @Column(name = "patient_id")
    private Long patientId;

    @PrePersist
    public void initializeUuid() {
        if (this.tranId == null) {
            this.tranId = UUID.randomUUID().toString();
        }
    }
}
