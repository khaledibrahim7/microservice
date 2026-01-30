package com.microservice.payment.service;


import com.microservice.payment.dto.PaymentRequest;
import com.microservice.payment.dto.PaymentResponse;
import com.microservice.payment.entity.Payment;
import com.microservice.payment.mapper.PaymentMapper;
import com.microservice.payment.repository.PaymentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepo paymentRepo;
    private final PaymentMapper paymentMapper;



    public PaymentResponse insert(PaymentRequest request){
        Payment payment = paymentMapper.toEntity(request);
        paymentRepo.save(payment);
        return paymentMapper.toDto(payment);
    }

    public PaymentResponse getById(Long id){
        Payment payment = paymentRepo.findById(id).get();
        return paymentMapper.toDto(payment);
    }

    public PaymentResponse getByTranId(String tranId){
        Payment payment = paymentRepo.findByTranId(tranId).get();
        return paymentMapper.toDto(payment);
    }
}
