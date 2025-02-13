package com.example.demo.service;

import com.example.demo.exception.CourseNotFoundException;
import com.example.demo.model.CourseV1;
import com.example.demo.repository.CourseRepositoryV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepositoryV1 courseRepository;

    public CourseV1 createCourse(CourseV1 course) {
        return courseRepository.save(course);
    }

    public Optional<CourseV1> getCourseById(long id) {
        return courseRepository.findById(id);
    }

    public Iterable<CourseV1> getCoursesByCategory(String category) {
        return courseRepository.findAllByCategory(category);
    }

    public Iterable<CourseV1> getCourses() {
        return courseRepository.findAll();
    }

    public CourseV1 updateCourse(Long id, CourseV1 course) {
        CourseV1 existingCourse = courseRepository.findById(id)
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
