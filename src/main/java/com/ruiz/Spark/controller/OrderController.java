package com.ruiz.Spark.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ruiz.Spark.model.OrderOriginal;
import com.ruiz.Spark.model.User;
import com.ruiz.Spark.service.OrderService;
import com.ruiz.Spark.service.ProductService;

@Controller
public class OrderController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired 
	private OrderService orderService;

	/**
	 * Method that shows the user
	 * all of orders they have
	 * @param model
	 * @return
	 */
	//May need to change html
	@GetMapping("/orders")
	public String showAllOrders(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication();
		List<OrderOriginal> orders = orderService.getAllOrdersByUser(user);
		model.addAttribute("myorders", orders);
		return "viewcart";
	}
	
	/**
	 * This method gets an order by Id
	 * and adds it to the "Model" object
	 * returns the html
	 * @param id
	 * @param model
	 * @return
	 */
	
	@GetMapping("/orders/{id}")
	public String showOrder(@PathVariable("id")Long id, Model model) {
		Optional<OrderOriginal> order = orderService.getOrderByID(id);
		model.addAttribute("myorder", order);
		return "viewCart";
	}
	
	
}
