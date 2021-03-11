package com.learning.service.admin;

import java.util.List;
import java.util.Optional;

import com.learning.model.Category;
import com.learning.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Optional<Category> findById(int id) {
		return categoryRepository.findById(id);
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category update(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public String deleteById(int id) {
		try {
			categoryRepository.deleteById(id);
			return "Product deleted..";
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not deleted", e);
		}

	}

}
