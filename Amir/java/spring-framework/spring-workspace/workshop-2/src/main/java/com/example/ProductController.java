package com.example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

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

	@RequestMapping(path = "/add")
	public ModelAndView addProduct(Model model) {
		ModelAndView mv = new ModelAndView("add-product");
		Product product = new Product();
		mv.addObject("product", product);
		return mv;
	}

	@RequestMapping(path = "/submit-product", method = RequestMethod.POST)
	public String submitProduct(@ModelAttribute("product") Product product) {
		Product p = productService.save(product);
		System.out.println("Product submitted : " + p);
		return "redirect:/products";
	}

	@RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView updateProduct(@PathVariable int id) {
		System.out.println("inside edit product");
		ModelAndView mv = new ModelAndView("edit-product");
		Product product = productService.findById(id).get();
		System.out.println("optonal " + product);
		mv.addObject("product", product);
		return mv;
	}

	@RequestMapping(path = "/delete/{id}")
	public String deleteProductById(@PathVariable int id) {
		productService.deleteById(id);
		System.out.println("Product deleted...");
		return "redirect:/products";
	}

}
