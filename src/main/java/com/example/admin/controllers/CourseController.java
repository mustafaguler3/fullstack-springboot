package com.example.admin.controllers;

import com.example.admin.entities.Course;
import com.example.admin.entities.Instructor;
import com.example.admin.service.CourseService;
import com.example.admin.service.InstructorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/courses")
public class CourseController {

    private CourseService courseService;
    private InstructorService instructorService;

    public CourseController(CourseService courseService, InstructorService instructorService) {
        this.courseService = courseService;
        this.instructorService = instructorService;
    }
    @GetMapping(value = "/index")
    public String courses(Model model, @RequestParam("keyword") String keyword){
        List<Course> courses = courseService.findCoursesByCourseName(keyword);
        model.addAttribute("listCourses",courses);
        model.addAttribute("keyword",keyword);

        return "course-views/courses";
    }
    @GetMapping(value = "/delete")
    public String deleteCourse(Long courseId,String keyword){
        courseService.removeCourse(courseId);
        return "redirect:/courses/index?keyword="+keyword;
    }

    @GetMapping(value = "/formUpdate")
    public String updateCourse(Model model,Long courseId){
        Course course = courseService.loadCourseById(courseId);
        List<Instructor> instructors = instructorService.fetchInstructors();
        model.addAttribute("course",course);
        model.addAttribute("listInstructors",instructors);

        return "redirect:/formUpdate";
    }

    @GetMapping(value = "/formCreate")
    public String formCourses(Model model){
        List<Instructor> instructors = instructorService.fetchInstructors();
        model.addAttribute("listInstructors",instructors);
        model.addAttribute("course",new Course());

        return "course-views/formCreate";
    }

    @GetMapping(value = "/save")
    public String save(Course course){
        courseService.createOrUpdateCourse(course);
        return "redirect:/courses/index";
    }
}























