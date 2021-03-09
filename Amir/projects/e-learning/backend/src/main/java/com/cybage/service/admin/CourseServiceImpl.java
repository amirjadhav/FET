package com.cybage.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.Course;
import com.cybage.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;
	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

}
