package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "COURSES")
public class CourseV1 {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "RATING")
    private int rating;

    @Column(name = "DESCRIPTION")
    private String description;

}
