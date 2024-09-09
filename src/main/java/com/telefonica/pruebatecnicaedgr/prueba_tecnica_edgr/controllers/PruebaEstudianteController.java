package com.telefonica.pruebatecnicaedgr.prueba_tecnica_edgr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telefonica.pruebatecnicaedgr.prueba_tecnica_edgr.dto.StudentDto;
import com.telefonica.pruebatecnicaedgr.prueba_tecnica_edgr.entities.Student;
import com.telefonica.pruebatecnicaedgr.prueba_tecnica_edgr.interfaces.IStudentService;


@RestController
@RequestMapping("/api/students")
public class PruebaEstudianteController {
    
    @Autowired
    IStudentService _service;
    
    @GetMapping("/getAll/{page}/{pageSize}")
    public ResponseEntity<Page<Student>> getAllStudents(@PathVariable Integer page, @PathVariable Integer pageSize) {
        return ResponseEntity.status(HttpStatus.OK).body(_service.getAllStudents(page, pageSize));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(_service.getStudentById(id));
    }
    
    @PostMapping("/save")
    public ResponseEntity<Boolean> saveStudent(@RequestBody StudentDto entity) {
        return ResponseEntity.status(HttpStatus.OK).body(_service.saveStudent(entity));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateStudent(@PathVariable Long id, @RequestBody StudentDto entity) {
        return ResponseEntity.status(HttpStatus.OK).body(_service.updateStudent(id, entity));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(_service.deleteStudent(id));
    }
}
