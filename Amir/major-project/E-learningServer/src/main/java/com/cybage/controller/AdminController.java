package com.cybage.controller;

import java.util.List;
import java.util.Optional;

import com.cybage.model.Category;
import com.cybage.service.admin.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RequestMapping("admin")
@RestController
public class AdminController {
	@Autowired
	CategoryService categoryService;

	@GetMapping()
	public String home() {
		return "Home";
	}

	/*********************** Category endpoints ***********************/

	@GetMapping("category")
	public List<Category> getCategory() {

		return categoryService.findAll();
	}

	@GetMapping("category/id")
	public Optional<Category> getCategoryById(@PathVariable int id) {
		return categoryService.findById(id);
	}

	@PostMapping("category")
	public Category addCategory(@RequestBody Category category) {
		return categoryService.save(category);
	}

	@PutMapping("category")
	public Category updateCategory(@RequestBody Category category) {
		return categoryService.save(category);
	}

	@DeleteMapping("category/{id}")
	public void deleteCategory(@PathVariable int id){
		categoryService.deleteCategoryById(id);
	}
}
