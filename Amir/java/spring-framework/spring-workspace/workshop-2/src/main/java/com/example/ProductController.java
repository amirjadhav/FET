package com.example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductService productService;

	@RequestMapping()
	public List<Product> getProducts() {
		return productService.findAll();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Optional<Product> getProductById(@PathVariable int id) {
		return productService.findById(id);

	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public Product addProduct(@RequestBody Product product) {
		return productService.save(product);
	}

	@RequestMapping(path = "/edit/{id}", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product, @PathVariable int id) {
		return productService.update(product);
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteProductById(@PathVariable int id) {
		System.out.println("id:" + id);
		productService.deleteById(id);
		System.out.println("Product deleted...");
	}

}
