package com.ruiz.Spark.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Product {
	
	/**
	 * Establish fields/attributes for the Product entity
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String color;
	@Column(nullable=false)
	private int price;
	
	/**
	 * Establish relationship with the other entities
	 * Product has a ManyToOne relationship with Orders and Category
	 * Product has a OneToManyRelationship with 
	 */
	@ManyToMany(mappedBy="products")
	private Set<Order> orders = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id")
	private Category category;
	
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL)
	List<Review> review = new ArrayList<>();
	
	/**
	 * Generate empty and parameterized constructors
	 */
	
	
	
	
	/**
	 * Generate Getters and Setters for attributes
	 * @return
	 */
	
	
	
	
}
