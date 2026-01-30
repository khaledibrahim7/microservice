package com.microservice.patient.service;

import com.microservice.patient.dto.PatientRequest;
import com.microservice.patient.dto.PatientResponse;
import com.microservice.patient.dto.UpdatePatientRequest;

import java.util.List;

public interface PatientService {

 String getName(String name);
    PatientResponse save(PatientRequest patientRequest);
    PatientResponse update(UpdatePatientRequest update);
    void deleteById(Long id);
    List<PatientResponse> getAll();
    PatientResponse getById(Long id);
}
