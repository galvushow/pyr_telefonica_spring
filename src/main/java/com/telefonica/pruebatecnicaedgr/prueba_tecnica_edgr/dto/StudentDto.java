package com.telefonica.pruebatecnicaedgr.prueba_tecnica_edgr.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    @JsonProperty("eId")
    private Long eId;
    @JsonProperty("nombre")
    private String Name;
    @JsonProperty("especialidad")
    private String specialty;
    @JsonProperty("grado")
    private String grade;
}
