package com.microservice.payment.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
    private double amount ;
    private Long patientId;
}
