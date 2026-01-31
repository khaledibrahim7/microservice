package com.microservice.doctor.controller;

import com.microservice.doctor.dto.PatientRequest;
import com.microservice.doctor.dto.PatientResponse;
import com.microservice.doctor.service.DoctorPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/patient")
public class PatientDoctorController {

    @Autowired
    private DoctorPatientService patientService;
    @GetMapping("/get-patient")
    public String getPatient(){
        return this.patientService.getPatient("Abd");
    }

    @GetMapping("/get-patient-feign/{name}")
    public String getPatientByFeign(@PathVariable String name){

        return this.patientService.getPatientByFeign(name);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getPatientById(@PathVariable Long id){
        return  ResponseEntity.ok(this.patientService.getPatientById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return  ResponseEntity.ok(this.patientService.getAll());
    }
    @PostMapping("/patient")
    public PatientResponse save(@RequestBody PatientRequest patientRequest){
          return patientService.save(patientRequest);
    }
}

