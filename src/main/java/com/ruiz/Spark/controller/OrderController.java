package com.ruiz.Spark.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.ruiz.Spark.model.OrderOriginal;
import com.ruiz.Spark.model.OrderProduct;
import com.ruiz.Spark.model.Product;
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
		OrderOriginal order = orderService.getOrderByID(id);
		model.addAttribute("myorder", order);
		return "viewCart";
	}
	/**
	 * Creates a new order with products and their quantity
	 * and returns the user to the orders page
	 * @param productList
	 * @param quantityList
	 * @return
	 */
	@PostMapping("/orders/neworder")
	public String createNewOrder(@RequestParam("productIds") List<Long> productList, @RequestParam("quantity") List<Integer> quantityList) {
		//securityContextHolder is where Spring Security stores details of who is authenticated
		User user = (User) SecurityContextHolder.getContext().getAuthentication();
		//Create a list to hold a list of products in an order
		List<OrderProduct> products = new ArrayList<>();
		for(int i =0; i<productList.size();i++) {
			Product product = productService.getProductById(productList.get(i));
			OrderProduct op= new OrderProduct();
			op.setProduct(product);
			op.setQuantity(quantityList.get(i));
			products.add(op);
		}
		orderService.createOrder(user, products);
		return "redirect:/orders";
		
	}
	
	/**
	 * Adds a OrderProduct to an existing order
	 * returns order view
	 * @param orderId
	 * @param productId
	 * @param quantity
	 * @return
	 */
	@PostMapping("/orders/{id}/addproduct")
	public String addProductToOrder(@PathVariable("id")Long orderId, @RequestParam("productId")Long productId, @RequestParam("quantity")int quantity) {
		Product product = productService.getProductById(productId);
		OrderOriginal order = orderService.getOrderByID(orderId);
		orderService.addProduct(order, product, quantity);
		return "redirect:/orders/{id}";
	}
	
	/**
	 * Gets order by Id and deletes the order
	 * returns to the order page
	 * @param id
	 * @return
	 */
	@DeleteMapping("/orders/{id}/cancelorder")
	public String cancelOrder(@PathVariable("id")Long id) {
		OrderOriginal order = orderService.getOrderByID(id);
		orderService.deleteOrder(order);
		return "redirect: /orders";
	}
}
