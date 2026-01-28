package com.microservice.doctor.controller;

import com.microservice.doctor.controller.service.DoctorPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientDoctorController {

    @Autowired
    private DoctorPatientService patientService;
    @GetMapping("/doctor/get-patient")
    public String getPatient(){
        return this.patientService.getPatient("Abd");
    }
}
