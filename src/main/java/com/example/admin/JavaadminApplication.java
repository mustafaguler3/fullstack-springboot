package com.example.admin;

import com.example.admin.dao.*;
import com.example.admin.utility.OperationUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaadminApplication implements CommandLineRunner {

    @Autowired
    private UserDao userDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private InstructorDao instructorDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private RoleDao roleDao;
    public static void main(String[] args) {
        SpringApplication.run(JavaadminApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        OperationUtility.usersOperations(userDao);
    }
}























