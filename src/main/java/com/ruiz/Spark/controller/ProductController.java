package com.ruiz.Spark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.ruiz.Spark.model.Product;
import com.ruiz.Spark.service.ProductService;

@Controller
public class ProductController {

	
	@Autowired
	private ProductService productService;
	
	/**
	 * This method gets a list of all products
	 * and adds it to the model attribute
	 * @param model
	 * @return
	 */
	@GetMapping("/collections")
	public String getAllProducts(Model model) {
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products",products);
		return "viewProducts";
	}
}
