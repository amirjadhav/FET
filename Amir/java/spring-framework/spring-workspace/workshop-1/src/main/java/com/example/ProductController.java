package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@RequestMapping()
	public ModelAndView getProducts() {
	    ModelAndView model = new ModelAndView("/index");
	    List<Product> product = productService.findAll();
	    model.addObject("product", product);
	    return model;
	}
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public String getProductById(@PathVariable int id) {
		Optional<Product> product = productService.findById(id);
		System.out.println(product);
		return "index";
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public String addProduct(@RequestBody Product product) {
		Product p = productService.save(product);
		System.out.println("Product added : " + p);
		return "index";
	}

	@RequestMapping(method = RequestMethod.PUT)
	public String updateProduct(@RequestBody Product product) {
		Product p = productService.save(product);
		System.out.println("Product updated : " + p);
		return "index";
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public String deleteProductById(@PathVariable int id) {
		productService.deleteById(id);
		System.out.println("Product deleted...");
		return "index";
	}

}
