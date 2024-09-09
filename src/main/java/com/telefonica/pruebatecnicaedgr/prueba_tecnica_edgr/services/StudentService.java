package com.telefonica.pruebatecnicaedgr.prueba_tecnica_edgr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.telefonica.pruebatecnicaedgr.prueba_tecnica_edgr.dto.StudentDto;
import com.telefonica.pruebatecnicaedgr.prueba_tecnica_edgr.entities.Student;
import com.telefonica.pruebatecnicaedgr.prueba_tecnica_edgr.exceptions.CustomHttpException;
import com.telefonica.pruebatecnicaedgr.prueba_tecnica_edgr.interfaces.IStudentService;
import com.telefonica.pruebatecnicaedgr.prueba_tecnica_edgr.repositories.IEstudianteRepository;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IEstudianteRepository _repository;

    @Override
    @Transactional(readOnly = true)
    public Page<Student> getAllStudents(Integer page, Integer pageSize) {
        Pageable pagedResult = PageRequest.of(page, pageSize, Sort.by("eId").ascending());

        return _repository.findAll(pagedResult);
    }

    @Override
    @Transactional(readOnly = true)
    public Student getStudentById(Long id) {
        return _repository.findById(id)
                .orElseThrow(() -> new CustomHttpException(HttpStatus.NOT_FOUND, "Student not found with id " + id));

    }

    @Override
    @Transactional
    public Boolean saveStudent(StudentDto payload) {
        if (isNullOrEmpty(payload.getGrade()) || isNullOrEmpty(payload.getName()) || isNullOrEmpty(payload.getName())) {
            throw new CustomHttpException(HttpStatus.BAD_REQUEST, "The data is mandatory");
        }
        Student student = adaptToStudent(payload);
        Student result = _repository.save(student);
        return result.getEId() > 0;
    }

    @Override
    @Transactional
    public Boolean updateStudent(Long id, StudentDto payload) {
        Student optionalStudent = _repository.findById(id).orElseThrow(() -> new CustomHttpException(HttpStatus.NOT_FOUND, "Student not found with id " + id));
        if (isNullOrEmpty(payload.getGrade()) || isNullOrEmpty(payload.getName()) || isNullOrEmpty(payload.getName())) {
            throw new CustomHttpException(HttpStatus.BAD_REQUEST, "The data is mandatory");
        }
        optionalStudent.setGrade(payload.getGrade());
        optionalStudent.setName(payload.getName());
        optionalStudent.setSpecialty(payload.getSpecialty());
        Student result = _repository.save(optionalStudent);
        return result.getEId() > 0;
    }

    @Override
    @Transactional
    public Boolean deleteStudent(Long id) {
        Student person = _repository.findById(id)
                .orElseThrow(() -> new CustomHttpException(HttpStatus.OK, "Student not found with id " + id));

        _repository.deleteById(person.getEId());
        return true;
    }

    // Método de adaptación
    private Student adaptToStudent(StudentDto dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setSpecialty(dto.getSpecialty());
        student.setGrade(dto.getGrade());
        return student;
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
    


}
