package com.ruiz.Spark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

	@GetMapping("/cart")
	public String showCart(Model model) {
		return "viewcart";
	}
}
