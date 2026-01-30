package com.microservice.payment.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {

    private Long id;
    private String tranId ;
    private double amount ;
    private Long patientId;


}
