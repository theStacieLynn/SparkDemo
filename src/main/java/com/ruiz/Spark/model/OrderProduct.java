package com.ruiz.Spark.model;

import jakarta.persistence.*;

@Entity
public class OrderProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private OrderOriginal order;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Product product;

	public OrderProduct(int quantity, OrderOriginal order, Product product) {
		super();
		this.quantity = quantity;
		this.order = order;
		this.product = product;
	}

	public OrderProduct() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderOriginal getOrder() {
		return order;
	}

	public void setOrder(OrderOriginal order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
