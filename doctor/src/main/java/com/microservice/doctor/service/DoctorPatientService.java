package com.microservice.doctor.service;

import com.microservice.doctor.dto.PatientRequest;
import com.microservice.doctor.dto.PatientResponse;
import com.microservice.doctor.proxy.PatientProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorPatientService {

   private final PatientProxy proxy;

   //old
    public String getPatient(String name){
        String fullUrl = "http://localhost:9001/search/Ahmad";
        RestTemplate restTemplate = new RestTemplate();
        String patientName = restTemplate
                .getForObject(fullUrl, String.class);
        return patientName;
    }

    //new
    public String getPatientByFeign(String name){
        return proxy.getName(name);
    }

    public PatientResponse getPatientById(Long id){
        return proxy.getById(id);
    }

    public List<PatientResponse> getAll(){
            return proxy.getAll();
    }
    public PatientResponse save(PatientRequest patientRequest){
        return proxy.save(patientRequest);
    }

}
