package com.microservice.payment.controller;

import com.microservice.payment.dto.PaymentRequest;
import com.microservice.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<?> save(PaymentRequest request){
        return ResponseEntity.ok(paymentService.insert(request));
    }
    @PostMapping("/id")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(paymentService.getById(id));
    }
    @PostMapping("/{ranId}")
    public ResponseEntity<?> getByTranId(@PathVariable String tranId) {
        return ResponseEntity.ok(paymentService.getByTranId(tranId));
    }



}
