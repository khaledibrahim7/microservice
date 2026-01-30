package com.microservice.patient.mapper;


import com.microservice.patient.dto.PatientRequest;
import com.microservice.patient.dto.PatientResponse;
import com.microservice.patient.dto.UpdatePatientRequest;
import com.microservice.patient.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {


    Patient toEntity(PatientRequest patientRequset);

    PatientResponse toDto(Patient patient);

    List<PatientResponse> toDto(List<Patient> patients);

    Patient toUpdateDto(UpdatePatientRequest dto, @MappingTarget Patient entity);
}
