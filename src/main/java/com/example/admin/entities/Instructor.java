package com.example.admin.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "instructors")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "instructor_id",nullable = false)
    private Long instructorId;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "summary",nullable = false,length = 250)
    private String summary;

    @OneToMany(mappedBy = "instructor",fetch = FetchType.LAZY)
    private Set<Course> courses = new HashSet<>();
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id",referencedColumnName = "user_id",nullable = false)
    private User user;

    public Instructor() {
    }

    public Instructor(String firstName, String lastName, String summary,String password) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.summary = summary;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
