package com.example.admin.service.Impl;

import com.example.admin.dao.CourseDao;
import com.example.admin.dao.InstructorDao;
import com.example.admin.dao.StudentDao;
import com.example.admin.entities.Course;
import com.example.admin.entities.Instructor;
import com.example.admin.entities.Student;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CourseServiceImplTest {

    @Mock
    private CourseDao courseDao;
    @Mock
    private InstructorDao instructorDao;
    @Mock
    private StudentDao studentDao;

    @InjectMocks
    private CourseServiceImpl courseService;

    @Test
    void loadCourseById() {
        Course course = new Course();
        course.setCourseId(1L);

        when(courseDao.findById(any())).thenReturn(Optional.of(course));

        assertEquals(1L,course);

    }

    @Test
    void testExceptionForNotFoundCourseById(){
        assertThrows(EntityNotFoundException.class, (Executable) courseService.loadCourseById(4L));
    }

    @Test
    void createCourse() {
        Instructor instructor = new Instructor();
        instructor.setInstructorId(1L);

        when(instructorDao.findById(any())).thenReturn(Optional.of(instructor));

        courseService.createCourse("JPA","10H","Very Good",instructor.getInstructorId());

        verify(courseDao).save(any());
    }

    @Test
    void createOrUpdateCourse() {
    }

    @Test
    void findCoursesByCourseName() {
        String courseName = "JPA";
        courseService.findCoursesByCourseName(courseName);

        verify(courseDao).findCoursesByCourseNameContains(courseName);
    }

    @Test
    void assignStudentToCourse() {
        Student student = new Student();
        student.setId(1L);
        Course course = new Course();
        course.setCourseId(1L);

        when(studentDao.findById(any())).thenReturn(Optional.of(student));
        when(courseDao.findById(any())).thenReturn(Optional.of(course));

        courseService.assignStudentToCourse(course.getCourseId(),student.getId());
    }

    @Test
    void fetchAll() {
        courseService.fetchAll();
        verify(courseDao).findAll();
    }

    @Test
    void fetchCoursesForStudent() {
        courseService.fetchCoursesForStudent(1L);
        verify(courseDao).getCoursesByStudentId(1L);
    }

    @Test
    void removeCourse() {
        courseService.removeCourse(1L);
        verify(courseDao).deleteById(1L);
    }
}




























