package com.cybage.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.service.admin.CategoryService;
import com.cybage.service.admin.CourseService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	/******************Category **********************/
	@Autowired
	CategoryService categoryService;
	@Autowired
	CourseService courseService;
	
	@GetMapping
	public List<Category> getAllCategories() {
		return categoryService.findAll(); 
	}
	@GetMapping("/{id}")
	public Optional<Category> getCategoryById(@PathVariable int id) {
		return categoryService.findById(id); 
	}
	
	@PostMapping
	public Category addCategory(@RequestBody Category category) {
		return categoryService.save(category); 
	}
	
	@PutMapping
	public Category updateCategory(@RequestBody Category category) {
		return categoryService.update(category); 
	}
	
	@DeleteMapping("/{id}")
	public String deleteCategoryById(@PathVariable int id) {
		return categoryService.deleteById(id); 
	}
	
	
	/******************Course **********************/
	
	@GetMapping("/course")
	public List<Course> getAllCourses(){
		System.out.println("Inside course gett");
		System.out.println("test"+courseService.findAll());
		return courseService.findAll();
	}
	
	
	
	
	
}
