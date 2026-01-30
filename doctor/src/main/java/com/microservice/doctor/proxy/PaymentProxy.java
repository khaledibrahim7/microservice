package com.microservice.doctor.proxy;

import com.microservice.doctor.dto.PaymentRequest;
import com.microservice.doctor.dto.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment")
public interface PaymentProxy {

    @PostMapping("/payment")
    PaymentResponse save(@RequestBody PaymentRequest request);

    @PostMapping("/payment/{id}")
    PaymentResponse getById(@PathVariable("id") Long id);

    @PostMapping("/payment/{tranId}")
      PaymentResponse getByTranId(@PathVariable("tranId") String tranId);
}
