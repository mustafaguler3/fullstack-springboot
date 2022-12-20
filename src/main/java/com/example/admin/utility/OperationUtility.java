package com.example.admin.utility;

import com.example.admin.dao.InstructorDao;
import com.example.admin.dao.RoleDao;
import com.example.admin.dao.StudentDao;
import com.example.admin.dao.UserDao;
import com.example.admin.entities.Instructor;
import com.example.admin.entities.Role;
import com.example.admin.entities.Student;
import com.example.admin.entities.User;
import jakarta.persistence.EntityNotFoundException;

public class OperationUtility {

    public static void usersOperations(UserDao userDao){
        createUsers(userDao);
        fetchUsers(userDao);
        updateUser(userDao);
        deleteUser(userDao);
    }

    private static void rolesOperations(RoleDao roleDao){
        createRoles(roleDao);
        updateRole(roleDao);
        fetchRole(roleDao);
    }

    private static void instructorOperations(UserDao userDao, InstructorDao instructorDao,RoleDao roleDao){

        createInstructors(userDao,instructorDao,roleDao);
        updateInstructor(instructorDao);
        removeInstructor(instructorDao);
    }

    private static void studentOperation(UserDao userDao, StudentDao studentDao,RoleDao roleDao){
        createStudents(userDao,studentDao,roleDao);
        updateStudent(studentDao);
        removeStudent(studentDao);
    }

    private static void createStudents(UserDao userDao, StudentDao studentDao,RoleDao roleDao){
        Role role = roleDao.findByName("Student");
        if (role == null) throw new EntityNotFoundException("Role not found");

        User user1 = new User();
        user1.setEmail("user1@hotmail.com");
        user1.setPassword("123");
        userDao.save(user1);
        user1.assignRoleToUser(role);

        Student student1 = new Student();
        student1.setFirstName("musti");
        student1.setLastName("güler");
        studentDao.save(student1);

    }

    private static void updateStudent(StudentDao studentDao){
        Student student = studentDao.findById(2L).orElseThrow(()->new EntityNotFoundException("Student not found"));
        student.setFirstName("updatedStdFN");
        student.setLastName("updatedStnLN");
        studentDao.save(student);
    }

    private static void removeStudent(StudentDao studentDao){
        studentDao.deleteById(1L);
    }

    private static void fetchStudents(StudentDao studentDao){
        studentDao.findAll().forEach(student -> System.out.println(student.toString()));
    }

    private static void createInstructors(UserDao userDao, InstructorDao instructorDao,RoleDao roleDao){
        Role role = roleDao.findByName("Instructor");
        if (role == null) throw new EntityNotFoundException("Role Not Found");
        User user1 = new User();
        user1.setEmail("instructor1@hotmail.com");
        user1.setPassword("123");
        userDao.save(user1);
        user1.assignRoleToUser(role);

        Instructor instructor = new Instructor();
        instructor.setFirstName("inst1");
        instructor.setLastName("inst2");
        instructor.setSummary("Experienced Instructor");
        instructorDao.save(instructor);


    }
    private static void updateInstructor(InstructorDao instructorDao){
        Instructor instructor = instructorDao.findById(1L).orElseThrow(()->new EntityNotFoundException("inst not " +
                "found"));
        instructor.setSummary("Lead Instructor");
        instructorDao.save(instructor);
    }

    private static void removeInstructor(InstructorDao instructorDao){
        instructorDao.deleteById(2L);
    }

    private static void createRoles(RoleDao roleDao){
        Role role1 = new Role();
        role1.setRoleId(1L);
        role1.setName("Admin");
        roleDao.save(role1);

        Role role2 = new Role();
        role2.setRoleId(1L);
        role2.setName("Student");
        roleDao.save(role2);

        Role role3 = new Role();
        role3.setRoleId(1L);
        role3.setName("Instructor");
        roleDao.save(role3);
    }

    private static void updateRole(RoleDao roleDao){
        Role role = roleDao.findById(1L).orElseThrow(() -> new EntityNotFoundException("Role Not Found"));
        role.setName("NewAdmin");
        roleDao.save(role);
    }

    private static void deleteRole(RoleDao roleDao){
        roleDao.deleteById(2L);
    }

    private static void fetchRole(RoleDao roleDao){
        roleDao.findAll().forEach(role -> System.out.println(role.toString()));
    }

    private static void createUsers(UserDao userDao){
        User user1 = new User();
        user1.setEmail("mustafa@hotmail.com");
        user1.setPassword("123");
        userDao.save(user1);

        User user2 = new User();
        user2.setEmail("mustafa2@hotmail.com");
        user2.setPassword("123");
        userDao.save(user2);
    }

    private static void updateUser(UserDao userDao){
        User user = userDao.findById(2L).orElseThrow(()->new EntityNotFoundException("User not found"));
        user.setEmail("new@hotmail.com");
        userDao.save(user);
    }

    private static void deleteUser(UserDao userDao){
        User user = userDao.findById(5L).orElseThrow(()->new EntityNotFoundException("User not found"));
        userDao.delete(user);
    }
    private static void fetchUsers(UserDao userDao){
        userDao.findAll().forEach(user -> System.out.println(user.toString()));
    }
}






















