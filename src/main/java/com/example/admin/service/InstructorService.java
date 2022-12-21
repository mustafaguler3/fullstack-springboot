package com.example.admin.service;

import com.example.admin.entities.Instructor;

import java.util.List;
import java.util.Optional;

public interface InstructorService {
    Optional<Instructor> loadInstructorById(Long instructorId);
    List<Instructor> findInstructorsByName(String name);
    Instructor loadInstructorByEmail(String email);
    List<Instructor> fetchInstructors();

    void createInstructor(Instructor instructor);
}




















