package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MODERN_COURSES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseV2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotEmpty
    @Column(name = "NAME")
    private String name;

    @NotEmpty
    @Column(name = "CATEGORY")
    private String category;

    @Min(value = 1, message = "Minimum rating value is 1")
    @Max(value = 5, message = "Maximum rating value is 5")
    @Column(name = "RATING")
    private int rating;

    @NotEmpty
    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull
    @Column(name = "PRICE")
    private double price;

}
