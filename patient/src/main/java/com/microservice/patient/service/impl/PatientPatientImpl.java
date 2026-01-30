package com.microservice.patient.service.impl;

import com.microservice.patient.dto.PatientRequest;
import com.microservice.patient.dto.PatientResponse;
import com.microservice.patient.dto.UpdatePatientRequest;
import com.microservice.patient.entity.Patient;
import com.microservice.patient.mapper.PatientMapper;
import com.microservice.patient.repository.PatientRepo;
import com.microservice.patient.service.PatientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientPatientImpl implements PatientService {

    private final PatientRepo patientRepo;
    private final PatientMapper patientMapper;

    private List<String> names = Arrays.asList("Ahmad", "Abd", "Khaled");

    public String getName(String name){
        return names.stream().filter(n -> n.equals(name))
                .findAny().orElse("No patient found!");
    }

    @Override
    public PatientResponse save(PatientRequest patientRequest) {
        Patient patient = patientMapper.toEntity(patientRequest);
        Patient savePatient = patientRepo.save(patient);
            return patientMapper.toDto(savePatient);
    }
@Override
@Transactional
    public PatientResponse update(UpdatePatientRequest update){
        Patient find = patientRepo.findById(update.getId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));
         patientMapper.toUpdateDto(update, find);
        Patient updatePatient = patientRepo.save(find);
        return patientMapper.toDto(updatePatient);
}

 public void deleteById(Long id){
        patientRepo.deleteById(id);
 }

     public List<PatientResponse> getAll(){
        List<Patient> all = patientRepo.findAll();
        return patientMapper.toDto(all);
     }
     public PatientResponse getById(Long id){
        Patient patient = patientRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        return patientMapper.toDto(patient);
     }
}
