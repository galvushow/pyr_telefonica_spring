package com.telefonica.pruebatecnicaedgr.prueba_tecnica_edgr.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="pruebaestudiante")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="eid")
    private Long eId;
    @Column(name="nombre")
    private String Name;
    @Column(name="especialidad")
    private String specialty;
    @Column(name="grado")
    private String grade;
}
