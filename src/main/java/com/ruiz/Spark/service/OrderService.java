package com.ruiz.Spark.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruiz.Spark.model.OrderOriginal;
import com.ruiz.Spark.model.OrderProduct;
import com.ruiz.Spark.model.Product;
import com.ruiz.Spark.model.User;
import com.ruiz.Spark.repository.OrderRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	
	/**
	 * Calculates the total of the order
	 * @param products
	 * @return
	 */
	public double calculateTotal(List<OrderProduct> products) {
		double total = 0;
	
		
		
		for(OrderProduct product: products) {
		
			total+=product.getProduct().getPrice()*product.getQuantity();
		}
		return total;
	}
	
	
	/**
	 * return all orders associated with a user
	 * @param user
	 * @return
	 */
	public OrderOriginal getOrderByUser(User user){
		return orderRepository.findByUser(user);
	}
	

	public void addOrderedProduct(OrderOriginal order, OrderProduct orderProduct) {
		orderProduct.setOrder(order);
		order.getItems().add(orderProduct);
		orderRepository.save(order);
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
	public void save(OrderOriginal order) {
		orderRepository.save(order);
	}
	
	public void deleteOrder(OrderOriginal order) {
		orderRepository.delete(order);
	}
	
	public OrderOriginal getOrderByID(Long id){
		OrderOriginal order = orderRepository.findById(id).orElse(null);
		if(order==null) {
			throw new EntityNotFoundException("Order with id "+id+" is not found.");
		}
		return order;
	}

}
