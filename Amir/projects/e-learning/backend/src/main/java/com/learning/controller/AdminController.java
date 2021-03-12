package com.learning.controller;

import java.util.List;
import java.util.Optional;

import com.learning.model.Category;
import com.learning.model.Course;
import com.learning.model.SubCourse;
import com.learning.service.admin.CategoryService;
import com.learning.service.admin.CourseService;
import com.learning.service.admin.SubCourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	CourseService courseService;
	@Autowired
	SubCourseService subCourseService;

	/****************** Category **********************/
	@GetMapping
	String adminHome() {
		return "Admin Home";
	}

	@GetMapping("category")
	public List<Category> getAllCategories() {
		return categoryService.findAll();
	}

	@GetMapping("category/{id}")
	public Optional<Category> getCategoryById(@PathVariable int id) {
		return categoryService.findById(id);
	}

	@PostMapping("category")
	public Category addCategory(@RequestBody Category category) {
		return categoryService.save(category);
	}

	@PutMapping("category")
	public Category updateCategory(@RequestBody Category category) {
		return categoryService.update(category);
	}

	@DeleteMapping("category/{id}")
	public String deleteCategoryById(@PathVariable int id) {
		return categoryService.deleteById(id);
	}

	/****************** Course **********************/

	@GetMapping("/course")
	public List<Course> getAllCourses() {
		return courseService.findAll();
	}

	@GetMapping("course/{id}")
	public Optional<Course> getCourseById(@PathVariable int id) {
		return courseService.findById(id);
	}

	@PostMapping("course")
	public Course addCourse(@RequestBody Course course) {
		return courseService.save(course);
	}

	@PutMapping("course")
	public Course updateCourse(@RequestBody Course course) {
		return courseService.update(course);
	}

	@DeleteMapping("course/{id}")
	public String deleteCourseById(@PathVariable int id) {
		return courseService.deleteById(id);
	}

	/****************** SubCourse **********************/

	@GetMapping("/subcourse")
	public List<SubCourse> getAllSubCourses() {
		return subCourseService.findAll();
	}

	@GetMapping("subcourse/{id}")
	public Optional<SubCourse> getSubCourseById(@PathVariable int id) {
		return subCourseService.findById(id);
	}

	@PostMapping("subcourse")
	public SubCourse addSubCourse(@RequestBody SubCourse subCourse) {
		return subCourseService.save(subCourse);
	}

	@PutMapping("subcourse")
	public SubCourse updateSubCourse(@RequestBody SubCourse subCourse) {
		return subCourseService.update(subCourse);
	}

	@DeleteMapping("subcourse/{id}")
	public String deleteSubCourseById(@PathVariable int id) {
		return subCourseService.deleteById(id);
	}
}
