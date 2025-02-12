package com.example.demo.service;

import com.example.demo.exception.CourseNotFoundException;
import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> getCourseById(long id) {
        return courseRepository.findById(id);
    }

    public Iterable<Course> getCoursesByCategory(String category) {
        return courseRepository.findAllByCategory(category);
    }

    public Iterable<Course> getCourses() {
        return courseRepository.findAll();
    }

    public Course updateCourse(Long id, Course course) {
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(String.format("No course with id %d is available", id)));
        existingCourse.setName(course.getName());
        existingCourse.setCategory(course.getCategory());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setRating(course.getRating());

        return courseRepository.save(existingCourse);
    }

    public void deleteCourses() {
        courseRepository.deleteAll();
    }

    public void deleteCourseById(long id) {
        courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(String.format("No course with id %d is available", id)));
        courseRepository.deleteById(id);
    }

}
