package com.telefonica.pruebatecnicaedgr.prueba_tecnica_edgr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telefonica.pruebatecnicaedgr.prueba_tecnica_edgr.entities.Student;

public interface IEstudianteRepository extends  JpaRepository<Student, Long> {
    
}
