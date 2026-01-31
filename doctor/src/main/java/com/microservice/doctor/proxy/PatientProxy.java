package com.microservice.doctor.proxy;

import com.microservice.doctor.dto.PatientRequest;
import com.microservice.doctor.dto.PatientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "patient",path = "/patient/patient")
public interface PatientProxy {

    @GetMapping("/search/{name}")
    String getName(@PathVariable("name") String name);

    @GetMapping
    List<PatientResponse> getAll();

    @GetMapping("/{id}")
    PatientResponse getById(@PathVariable("id") Long id);
    @PostMapping
    public PatientResponse save(@RequestBody PatientRequest patientRequest);


}
