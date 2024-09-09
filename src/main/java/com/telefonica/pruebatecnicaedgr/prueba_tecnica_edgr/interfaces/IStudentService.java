package com.telefonica.pruebatecnicaedgr.prueba_tecnica_edgr.interfaces;


import org.springframework.data.domain.Page;

import com.telefonica.pruebatecnicaedgr.prueba_tecnica_edgr.dto.StudentDto;
import com.telefonica.pruebatecnicaedgr.prueba_tecnica_edgr.entities.Student;

public interface IStudentService {
    Page<Student> getAllStudents(Integer page, Integer pageSize);

    Student getStudentById(Long id);

    Boolean saveStudent(StudentDto payload);

    Boolean updateStudent(Long id, StudentDto payload);

    Boolean deleteStudent(Long id);
}
