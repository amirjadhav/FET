package com.cybage.service.admin;

import java.util.List;
import java.util.Optional;

import com.cybage.model.Category;

public interface CategoryService {

	List<Category> findAll();

	Category save(Category category);

	Optional<Category> findById(int id);

	void deleteCategoryById(int id);

}
