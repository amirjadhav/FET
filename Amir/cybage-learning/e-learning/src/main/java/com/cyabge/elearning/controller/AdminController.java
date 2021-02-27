package com.cyabge.elearning.controller;

import java.util.List;

import com.cyabge.elearning.model.Category;
import com.cyabge.elearning.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api")
@RestController
public class AdminController {

    @Autowired
    CategoryService catService;

    @GetMapping
    public String home() {
        return "Home";
    }

    @GetMapping("/category")
    public List<Category> getCategory() {
        return catService.findAll();
    }

    @PostMapping("/category")
    public Category addCategory(@RequestBody Category category) {
        System.out.println(" category is :"+category);
        return catService.save(category);
    }
}
