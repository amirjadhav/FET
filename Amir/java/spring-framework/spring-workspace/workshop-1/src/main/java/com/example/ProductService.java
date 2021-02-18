package com.example;

import java.util.List;
import java.util.Optional;

public interface ProductService {
	public List<Product> findAll();

	public Optional<Product> findById(int id);

	public Product save(Product product);

	public Product update(Product product);

	public void deleteById(int id);
}
