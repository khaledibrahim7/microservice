package com.microservice.doctor.controller;

import com.microservice.doctor.dto.PatientRequest;
import com.microservice.doctor.dto.PatientResponse;
import com.microservice.doctor.dto.PaymentRequest;
import com.microservice.doctor.service.DoctorPatientService;
import com.microservice.doctor.service.DoctorPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentDoctorController {

    @Autowired
    private DoctorPaymentService paymentService;
    @PostMapping("/payment")
    public ResponseEntity<?> save (@RequestBody PaymentRequest request){
        return ResponseEntity.ok(this.paymentService.insert(request));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(this.paymentService.getById(id));
    }
    @GetMapping("/tranId/{tranId}")
    public ResponseEntity<?> getByTranId(@PathVariable String tranId){
        return ResponseEntity.ok(this.paymentService.getByTranId(tranId));
    }


}

