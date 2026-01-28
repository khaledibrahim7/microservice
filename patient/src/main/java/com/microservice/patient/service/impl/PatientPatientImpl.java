package com.microservice.patient.service.impl;

import com.microservice.patient.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PatientPatientImpl implements PatientService {

    private List<String> names = Arrays.asList("Ahmad", "Abd", "Khaled");

    public String getName(String name){
        return names.stream().filter(n -> n.equals(name))
                .findAny().orElse("No patient found!");
    }
}
