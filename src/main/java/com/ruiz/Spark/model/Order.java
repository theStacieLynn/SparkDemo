package com.ruiz.Spark.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;


@Entity
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private LocalDateTime date;
	@Column
	private double total;
	
	@ManyToMany
	@JoinTable(
			name = "oder_product",
			joinColumns = @JoinColumn(name="order_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id"))	
	private Set<Product> products = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id")
	private User user;
}
