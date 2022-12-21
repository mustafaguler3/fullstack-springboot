package com.example.admin;

import com.example.admin.dao.*;
import com.example.admin.entities.Course;
import com.example.admin.entities.Instructor;
import com.example.admin.entities.Student;
import com.example.admin.entities.User;
import com.example.admin.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaadminApplication {

    public static final String ADMIN = "ADMIN";
    public static final String INSTRUCTOR = "INSTRUCTOR";
    public static final String USER = "USER";
    public static void main(String[] args) {
        SpringApplication.run(JavaadminApplication.class, args);
    }

    @Bean
    CommandLineRunner start(UserService userService, RoleService roleService, StudentService studentService,
                            InstructorService instructorService, CourseService courseService){
        return args -> {
            User user1 = userService.createUser("user1@hotmail.com","123");
            User user2 = userService.createUser("user2@hotmail.com","123");
            User user3 = userService.createUser("user3@hotmail.com","123");
            roleService.createRole(ADMIN);
            roleService.createRole(USER);
            roleService.createRole(INSTRUCTOR);

            userService.assignRoleToUser(user1.getEmail(),ADMIN);
            userService.assignRoleToUser(user2.getEmail(),USER);
            userService.assignRoleToUser(user3.getEmail(),INSTRUCTOR);

            Instructor instructor1 = new Instructor(1L,"musti","gül","experiented instructor");
            Instructor instructor2 = new Instructor(2L,"musa","gül","experiented instructor");

            instructorService.createInstructor(instructor1);
            instructorService.createInstructor(instructor2);

            Course course1 = courseService.createCourse("Spring JPA","10H","Very good",instructor1.getInstructorId());

            Course course2 = courseService.createCourse("JavaEE","12H","Very good",instructor2.getInstructorId());

            Student student1 = studentService.createStudent("Hasan","Gülmez","4","hasan@hotmail.com","123");
            Student student2 = studentService.createStudent("Mehmet","Güler","5","mehmetn@hotmail.com","123");

            courseService.assignStudentToCourse(course1.getCourseId(),student1.getId());
            courseService.assignStudentToCourse(course2.getCourseId(),student2.getId());
        };
    }
}























