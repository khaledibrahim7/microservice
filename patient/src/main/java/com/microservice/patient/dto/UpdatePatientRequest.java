package com.microservice.patient.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdatePatientRequest {

    private Long id;
    private String name;

}
