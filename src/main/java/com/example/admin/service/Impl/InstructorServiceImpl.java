package com.example.admin.service.Impl;

import com.example.admin.dao.InstructorDao;
import com.example.admin.entities.Instructor;
import com.example.admin.service.InstructorService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InstructorServiceImpl implements InstructorService {

    private InstructorDao instructorDao;

    @Override
    public Optional<Instructor> loadInstructorById(Long instructorId) {
        return instructorDao.findById(instructorId);
    }

    @Override
    public List<Instructor> findInstructorsByName(String name) {
        return instructorDao.findInstructorsByName(name);
    }

    @Override
    public Instructor loadInstructorByEmail(String email) {
        return instructorDao.findInstructorsByEmail(email);
    }

    @Override
    public List<Instructor> fetchInstructors() {
        return instructorDao.findAll();
    }

    @Override
    public void createInstructor(Instructor instructor) {
        instructorDao.save(instructor);
    }
}
