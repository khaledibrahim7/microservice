package com.microservice.payment.mapper;

import com.microservice.payment.dto.PaymentRequest;
import com.microservice.payment.dto.PaymentResponse;
import com.microservice.payment.entity.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {


    PaymentResponse toDto(Payment payment);
      Payment toEntity(PaymentRequest request);

}
