package com.example.admin.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;
    @Column(name = "course_name",nullable = false,length = 45)
    private String courseName;
    @Column(name = "course_duration",nullable = false,length = 45)
    private String courseDuration;
    @Column(name = "course_description")
    private String courseDescription;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id",referencedColumnName = "instructor_id")
    private Instructor instructor;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "enrolled_in",
    joinColumns = {@JoinColumn(name = "course_id")},
    inverseJoinColumns = {@JoinColumn(name = "student_id")})
    private Set<Student> students = new HashSet<>();

    public void assignStudentToCourse(Student student){
        this.students.add(student);
        student.getCourses().add(this);
    }

    public void removeStudentFromCourse(Student student){
        this.students.remove(student);
        student.getCourses().remove(this);
    }

    public Course() {
    }

    public Course(String courseName, String courseDuration, String courseDescription, Instructor instructor) {
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this.courseDescription = courseDescription;
        this.instructor = instructor;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
}
