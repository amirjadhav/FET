package com.example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
		try {
			return productService.findById(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found", e);
		}

	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public Product addProduct(@RequestBody Product product) {
		try {
			return productService.save(product);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR", e);
		}
	}

	@RequestMapping(path = "/edit/{id}", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product, @PathVariable int id) {
		try {
			return productService.update(product);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR", e);
		}
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteProductById(@PathVariable int id) {
		try {
			System.out.println("id:" + id);
			productService.deleteById(id);
			System.out.println("Product deleted...");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not deleted", e);
		}
	}

}
