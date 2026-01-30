package com.microservice.doctor.service;

import com.microservice.doctor.dto.PatientRequest;
import com.microservice.doctor.dto.PatientResponse;
import com.microservice.doctor.dto.PaymentRequest;
import com.microservice.doctor.dto.PaymentResponse;
import com.microservice.doctor.proxy.PatientProxy;
import com.microservice.doctor.proxy.PaymentProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorPaymentService {

   private final PaymentProxy proxy;



    public PaymentResponse insert(PaymentRequest request){
         return proxy.save(request);
    }


    public PaymentResponse getById(Long id){
        return proxy.getById(id);
    }

    public PaymentResponse getByTranId(String tranId){
       return proxy.getByTranId(tranId);
    }
}
