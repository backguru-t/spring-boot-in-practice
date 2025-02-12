package com.example.demo.service;

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

    public void updateCourse(Long id, Course course) {
        courseRepository.findById(id).ifPresent(dbCourse -> {
            dbCourse.setName(course.getName());
            dbCourse.setCategory(course.getCategory());
            dbCourse.setDescription(course.getDescription());
            dbCourse.setRating(course.getRating());

            courseRepository.save(dbCourse);
        });
    }

    public void deleteCourses() {
        courseRepository.deleteAll();
    }

    public void deleteCourseById(long id) {
        courseRepository.deleteById(id);
    }

}
