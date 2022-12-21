package com.example.admin.dao;

import com.example.admin.entities.Instructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(scripts = {"file:src/main/resources/db/clearAll.sql","file:src/main/resources/db/admin-db.sql"})
class InstructorDaoTest {

    @Autowired
    private InstructorDao instructorDao;

    @Test
    void findInstructorsByName() {
        List<Instructor> instructors = instructorDao.findInstructorsByName("instName");
        int expected = 1;
        assertEquals(expected,instructors.size());
    }

    @Test
    void findInstructorsByEmail() {
        Instructor instructor = new Instructor();
        instructor.setInstructorId(1L);
        instructor.setFirstName("instName");
        instructor.setLastName("instLName");
        Instructor instructor1 = instructorDao.findInstructorsByEmail("instructor@hotmail.com");
        assertEquals(instructor,instructor1);
    }
}

























