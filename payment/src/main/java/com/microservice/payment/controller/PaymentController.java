package com.microservice.payment.controller;

import com.microservice.payment.dto.PaymentRequest;
import com.microservice.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody PaymentRequest request){
        return ResponseEntity.ok(paymentService.insert(request));
    }
    @GetMapping("id/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(paymentService.getById(id));
    }
    @GetMapping("/{tranId}")
    public ResponseEntity<?> getByTranId(@PathVariable String tranId) {
        return ResponseEntity.ok(paymentService.getByTranId(tranId));
    }



}
