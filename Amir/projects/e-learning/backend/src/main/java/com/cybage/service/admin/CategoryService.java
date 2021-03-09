package com.cybage.service.admin;

import java.util.List;
import java.util.Optional;

import com.cybage.model.Category;

public interface CategoryService {

	List<Category> findAll();

	Optional<Category> findById(int id);

	Category save(Category category);

	Category update(Category category);

	String deleteById(int id);

}
