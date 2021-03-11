package com.learning.service.admin;

import java.util.List;
import java.util.Optional;

import com.learning.model.Course;

public interface CourseService {

	List<Course> findAll();

    Optional<Course> findById(int id);

    Course save(Course course);

    Course update(Course course);

    String deleteById(int id);

}
