package com.learning.service.admin;

import java.util.List;
import java.util.Optional;

import com.learning.model.Course;
import com.learning.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;

	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	public Optional<Course> findById(int id) {
		return courseRepository.findById(id);
	}

	@Override
	public Course save(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Course update(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public String deleteById(int id) {
		try {
			courseRepository.deleteById(id);
			return "Course deleted..";
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not deleted", e);
		}
	}

}
