package com.cybage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
