package com.example.demo.controller;

import com.example.demo.model.CourseV2;
import com.example.demo.repository.CourseRepositoryV2;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses/v2")
@RequiredArgsConstructor
public class CourseControllerV2 {

    private final CourseRepositoryV2 courseRepositoryV2;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<CourseV2> getAllCourses() {
        return courseRepositoryV2.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CourseV2 createCourse(@Valid @RequestBody CourseV2 modernCourse) {
        return courseRepositoryV2.save(modernCourse);
    }

}
