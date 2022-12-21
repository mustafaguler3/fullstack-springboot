package com.example.admin.service.Impl;

import com.example.admin.dao.InstructorDao;
import com.example.admin.entities.Instructor;
import com.example.admin.entities.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InstructorServiceImplTest {

    @Mock
    private InstructorDao instructorDao;
    @InjectMocks
    private InstructorServiceImpl instructorService;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void loadInstructorById() {
        Instructor instructor = new Instructor();
        instructor.setInstructorId(1L);

        when(instructorDao.findById(1L)).thenReturn(Optional.of(instructor));

        Optional<Instructor> actual = instructorService.loadInstructorById(1L);

        assertEquals(instructor,actual);
    }

    @Test
    void findInstructorsByName() {
        String name = "instFirst";
        instructorService.findInstructorsByName(name);
        verify(instructorDao).findInstructorsByName(name);
    }

    @Test
    void loadInstructorByEmail() {
        String email = "mustafa@hotmail.com";
        instructorService.findInstructorsByName(email);
        verify(instructorDao).findInstructorsByName(email);
    }

    @Test
    void fetchInstructors() {
        instructorService.fetchInstructors();
        verify(instructorDao).findAll();
    }

    @Test
    void createInstructor() {
        User user = new User("user1@hotmail.com","123");

        when(userService.createUser(any(),any())).thenReturn(user);

        instructorService.createInstructor(new Instructor("fName","lName","ver","123"));

        verify(instructorDao).save(any());
    }
}

























