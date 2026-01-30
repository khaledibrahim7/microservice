package com.microservice.doctor.proxy;

import com.microservice.doctor.dto.PatientRequest;
import com.microservice.doctor.dto.PatientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "patient")
public interface PatientProxy {

    @GetMapping("/patient/search/{name}")
    String getName(@PathVariable("name") String name);

    @GetMapping("/patient")
    List<PatientResponse> getAll();

    @GetMapping("/patient/{id}")
    PatientResponse getById(@PathVariable("id") Long id);
    @PostMapping
    public PatientResponse save(@RequestBody PatientRequest patientRequest);


}
