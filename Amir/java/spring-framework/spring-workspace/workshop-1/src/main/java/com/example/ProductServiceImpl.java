package com.example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository pr;

	@Override
	public List<Product> findAll() {
		return pr.findAll();
	}

	@Override
	public Optional<Product> findById(int id) {
		return pr.findById(id);
	}

	@Override
	public Product save(Product product) {
		return pr.save(product);
	}

	@Override
	public Product update(Product product) {
		return pr.save(product);
	}

	@Override
	public void deleteById(int id) {
		pr.deleteById(id);
	}
}
