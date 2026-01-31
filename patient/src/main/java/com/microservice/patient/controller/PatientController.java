package com.microservice.patient.controller;

import com.microservice.patient.dto.PatientRequest;
import com.microservice.patient.dto.PatientResponse;
import com.microservice.patient.dto.UpdatePatientRequest;
import com.microservice.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController  {

    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.patientService.getAll());
    }

    @GetMapping("/{id}")
    public PatientResponse getById(@PathVariable("id") Long id){
        return this.patientService.getById(id);
    }


    @GetMapping("/search/{name}")
    public String getName(@PathVariable("name") String name){
        log.info("new request : " + UUID.randomUUID());
        return this.patientService.getName(name);
    }

    @PostMapping
    public PatientResponse save(@RequestBody PatientRequest patientRequest){
        return this.patientService.save(patientRequest);
    }

    @PutMapping
    public PatientResponse update(@RequestBody UpdatePatientRequest update){
        return this.patientService.update(update);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        this.patientService.deleteById(id);
    }
}
