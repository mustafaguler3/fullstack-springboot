package com.example.admin.service;

import com.example.admin.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student loadStudentById(Long studentId);
    List<Student> findStudentsByName(String name);
    Student loadStudentByEmail(String email);
    Student createStudent(String firstName,String lastName,String level,String email,String password);
    List<Student> fetchStudents();
    void removeStudent(Long studentId);
}

















