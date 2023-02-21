package com.ruiz.Spark.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ruiz.Spark.model.OrderOriginal;
import com.ruiz.Spark.model.OrderProduct;
import com.ruiz.Spark.model.Product;
import com.ruiz.Spark.model.User;
import com.ruiz.Spark.service.OrderService;
import com.ruiz.Spark.service.ProductService;
import com.ruiz.Spark.service.UserService;

import jakarta.servlet.http.HttpSession;


@Controller
public class OrderController {
	

	@Autowired
	private ProductService productService;
	
	@Autowired 
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	
	
	@ModelAttribute("user")
	public User getUserSession() {
		String userEmail = getUserEmail();
		User user = userService.findbyEmail(userEmail);
		return user;
	}
	public String getUserEmail() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	
	

	

	
	@GetMapping("/orders")
	public String showOrder(Model model, RedirectAttributes redirectAttributes) {
		User user = getUserSession();
		OrderOriginal order = orderService.getOrderByUser(user);
		if(order==null) {
			//model.addAttribute("error", "You have no orders at this time.");
			redirectAttributes.addFlashAttribute("error", "You have no orders at this time");
			return "redirect:/collections";
		}
		model.addAttribute("myorder", order);
		return "viewCart";
	}
	

	@GetMapping("orders/addproduct")
	public String showAddProductToOrderForm(@RequestParam Long productId, Model model) {
	    Product product = productService.getProductById(productId);
	    if (product == null) {
	        model.addAttribute("error", "Product not found.");
	    } else {
	        model.addAttribute("product", product);
	        model.addAttribute("quantity", 1);
	    }
	    return "viewProducts";
	}

	@PostMapping("orders/addproduct")
	public String processAddProductToOrder(@RequestParam Long productId, @RequestParam int quantity,
	                                       HttpSession session,
	                                       RedirectAttributes redirectAttributes) {

	    // Get the current customer's order
		User user = getUserSession();
		OrderOriginal order = orderService.getOrderByUser(user);

	    // Get the product to add to the order
	    Product product = productService.getProductById(productId);
	    // If no order exists for the user, create a new order
	    if (order == null) {
	        order = new OrderOriginal();
	        order.setUser(user);
	    }

	    // Create a new OrderProduct and set its properties
	    OrderProduct orderProduct = new OrderProduct();
	    orderProduct.setProduct(product);
	    orderProduct.setQuantity(quantity);
	    orderProduct.setOrder(order);
	   

	    // Save the product before saving the order product
	    productService.save(product);
	    
	    // Calculate the total of the order
	    double firstItem = orderProduct.getProduct().getPrice() *quantity;

	    double otheritems = orderService.calculateTotal(order.getItems());
	    double total = firstItem+otheritems;
	    order.setTotal(total);
	    
	    // Add the OrderProduct to the Order
	    order.getItems().add(orderProduct);
	    

	    // Save the Order to the database
	    orderService.save(order);

	    redirectAttributes.addFlashAttribute("message", "Product added to order!");

	    return "redirect:/collections";
	}
	
	
	/**
	 * Gets order by Id and deletes the order
	 * returns to the order page
	 * @param id
	 * @return
	 */
	@GetMapping("/orders/cancelorder")
	public String cancelOrder(Long id, Model model ) {
		
		OrderOriginal order = orderService.getOrderByID(id);
		orderService.deleteOrder(order);
		
		return "cancel_order";
	}
}
