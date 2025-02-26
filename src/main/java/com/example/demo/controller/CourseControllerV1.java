package com.example.demo.controller;

import com.example.demo.model.CourseV1;
import com.example.demo.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/courses/")
@RequiredArgsConstructor
@Tag(name = "Course Controller", description = "This REST controller provide services to manage courses in the Course Tracker application")
public class CourseControllerV1 {

    private final CourseService courseService;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Provides all courses available in the Course Tracker application")
    public Iterable<CourseV1> getAllCourses() {
        return courseService.getCourses();
    }

    @GetMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Provides course details for the supplied course id from the Course Tracker application")
    public Optional<CourseV1> getCourseById(@PathVariable("id") long id) {
        return courseService.getCourseById(id);
    }

    @GetMapping("category/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Provides course details for the supplied course category from the Course Tracker application")
    public Iterable<CourseV1> getCoursesByCategory(@PathVariable("name") String category) {
        return courseService.getCoursesByCategory(category);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Creates a new course in the Course Tracker application")
    public CourseV1 createCourse(@RequestBody CourseV1 course) {
        return courseService.createCourse(course);
    }

    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Updates the course details in the Course Tracker application for the supplied course id")
    public void updateCourse(@PathVariable("id") long id, @RequestBody CourseV1 course) {
        courseService.updateCourse(id, course);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletes the course details for the supplied course id from the Course Tracker application")
    void deleteCourseById(@PathVariable("id") long courseId) {
        courseService.deleteCourseById(courseId);
    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletes all courses from the Course Tracker application")
    void deleteCourses() {
        courseService.deleteCourses();
    }

}
