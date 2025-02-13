package com.example.demo.repository;

import com.example.demo.model.CourseV1;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepositoryV1 extends CrudRepository<CourseV1, Long> {

    Iterable<CourseV1> findAllByCategory(String category);

}
