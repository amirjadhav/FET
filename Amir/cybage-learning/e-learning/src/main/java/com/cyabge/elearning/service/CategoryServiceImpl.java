package com.cyabge.elearning.service;

import java.util.List;

import com.cyabge.elearning.model.Category;
import com.cyabge.elearning.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
      return categoryRepository.save(category);
    }

}
