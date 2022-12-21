package com.example.admin.service.Impl;

import com.example.admin.dao.StudentDao;
import com.example.admin.entities.Course;
import com.example.admin.entities.Student;
import com.example.admin.entities.User;
import com.example.admin.service.StudentService;
import com.example.admin.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;
    private UserService userService;

    @Override
    public Student loadStudentById(Long studentId) {
        return studentDao.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Student with id " + studentId + " Not Found"));
    }

    @Override
    public List<Student> findStudentsByName(String name) {
        return studentDao.findStudentsByName(name);
    }

    @Override
    public Student loadStudentByEmail(String email) {
        return studentDao.findStudentByEmail(email);
    }

    @Override
    public Student createStudent(String firstName, String lastName, String level, String email, String password) {
        User user = userService.createUser(email,password);
        userService.assignRoleToUser(email,"Student");
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLevel(level);
        student.setLastName(lastName);
        return studentDao.save(student);
    }

    @Override
    public List<Student> fetchStudents() {
        return studentDao.findAll();
    }

    @Override
    public void removeStudent(Long studentId) {
        Student student = loadStudentById(studentId);
        Iterator<Course> iterator = student.getCourses().iterator();
        if(iterator.hasNext()) {
            Course course = iterator.next();
            course.removeStudentFromCourse(student);
        }
        studentDao.deleteById(studentId);
    }
}
