package com.example.admin.dao;

import com.example.admin.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseDao extends JpaRepository<Course,Long> {

    List<Course> findCoursesByCourseNameContains(String name);

    @Query(value = "select c from Course as c where c.courseId in (select e.course_id from enrolled_in as e where e" +
            ".student_id=:studentId)")
    List<Course> getCoursesByStudentId(@Param("studentId") Long studentId);
}














