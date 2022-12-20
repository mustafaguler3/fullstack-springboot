package com.example.admin.service.Impl;

import com.example.admin.dao.CourseDao;
import com.example.admin.dao.InstructorDao;
import com.example.admin.entities.Course;
import com.example.admin.entities.Instructor;
import com.example.admin.service.CourseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private InstructorDao instructorDao;
    private CourseDao courseDao;

    public CourseServiceImpl(InstructorDao instructorDao, CourseDao courseDao) {
        this.instructorDao = instructorDao;
        this.courseDao = courseDao;
    }

    @Override
    public Course loadCourseById(Long courseId) {
        return courseDao.findById(courseId).orElseThrow(()->new EntityNotFoundException("Course with id"));
    }

    @Override
    public Course createCourse(String courseName, String courseDuration, String courseDesc,Long instructorId) {
        Instructor instructor = instructorDao.findById(instructorId).orElseThrow(()->new EntityNotFoundException());

        return courseDao.save(new Course(courseName,courseDuration,courseDesc,instructor));
    }

    @Override
    public Course createOrUpdateCourse(Course course) {
        return courseDao.save(course);
    }

    @Override
    public List<Course> findCoursesByCourseName(String keyword) {
        return courseDao.findCoursesByCourseNameContains(keyword);
    }

    @Override
    public void assignStudentToCourse(Long courseId, Long studentId) {

    }

    @Override
    public List<Course> fetchAll() {
        return courseDao.findAll();
    }

    @Override
    public List<Course> fetchCoursesForStudent(Long studentId) {
        return courseDao.getCoursesByStudentId(studentId);
    }

    @Override
    public void removeCourse(Long courseId) {
        courseDao.deleteById(courseId);
    }
}
