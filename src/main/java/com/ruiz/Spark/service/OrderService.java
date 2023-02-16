package com.ruiz.Spark.service;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruiz.Spark.model.OrderOriginal;
import com.ruiz.Spark.model.OrderProduct;
import com.ruiz.Spark.model.Product;
import com.ruiz.Spark.model.User;
import com.ruiz.Spark.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	
	/**
	 * method to create an order with specified user, calculates total,
	 * and saves order to the repo
	 * @param user
	 * @param items
	 * @return
	 */
	public OrderOriginal createOrder(User user, List<OrderProduct> items) {
		OrderOriginal order = new OrderOriginal();
		order.setUser(user);
		order.setDate(LocalDateTime.now());
		order.setItems(items);
		order.setTotal(calculateTotal(items));
		return orderRepository.save(order);
	}
	
	
	/**
	 * Calculates the total of the order
	 * @param products
	 * @return
	 */
	private double calculateTotal(List<OrderProduct> products) {
		double total = 0;
		for(OrderProduct product: products) {
			total+=product.getProduct().getPrice();
		}
		return total;
	}
	
	
	/**
	 * return all orders associated with a user
	 * @param user
	 * @return
	 */
	public List<OrderOriginal> getAllOrdersByUser(User user){
		return orderRepository.findByUser(user);
	}
	
	/**
	 * Adds a new OrderProduct to an existing order, updates order total price
	 * and saves the updated order
	 * @param order
	 * @param product
	 * @param quantity
	 */
	public void addProduct(OrderOriginal order, Product product, int quantity) {
		OrderProduct item = new OrderProduct();
		double price = product.getPrice();
		double totalForProduct = price*quantity;
		double total = (order.getTotal())+totalForProduct;
		item.setProduct(product);
		item.setOrder(order);
		item.setQuantity(quantity);
		order.getItems().add(item);
		order.setTotal(total);
		saveOrder(order);
	}
	
	/**
	 * Removes a product from the order, updates total and
	 * saves updates order to the repo
	 * @param order
	 * @param product
	 */
	public void removeProduct(OrderOriginal order, Product product) {
		order.getItems().removeIf(item -> item.getProduct().equals(product));
		double total = calculateTotal(order.getItems());
		order.setTotal(total);
		orderRepository.save(order);
	}
	
	/*
	 * saves order to the repository
	 */
	public void saveOrder(OrderOriginal order) {
		orderRepository.save(order);
	}
}
