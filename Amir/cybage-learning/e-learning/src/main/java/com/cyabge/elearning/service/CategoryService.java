package com.cyabge.elearning.service;

import java.util.List;

import com.cyabge.elearning.model.Category;

public interface CategoryService {

    List<Category> findAll();

	Category save(Category category);

}
