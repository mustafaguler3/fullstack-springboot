package com.example.admin.dao;

import com.example.admin.AbstractTest;
import com.example.admin.entities.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(scripts = {"file:src/main/resources/db/clearAll.sql","file:src/main/resources/db/admin-db.sql"})
class CourseDaoTest extends AbstractTest {

    @Autowired
    private CourseDao courseDao;

    @Test
    void findCoursesByCourseNameContains() {
        List<Course> courses = courseDao.findCoursesByCourseNameContains("Spring");
        int expect = 2;
        assertEquals(expect,courses.size());
    }

    @Test
    void getCoursesByStudentId() {
        List<Course> courses = courseDao.getCoursesByStudentId(1L);
        int expected = 1;
        assertEquals(expected,courses.size());
    }
}














