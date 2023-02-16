package com.ruiz.Spark.model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
/**
 * 
 * @author s_lyn, Stacie Ruiz
 *
 */
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
	 * Product has a ManyToOne relationship with Category
	 * Product has a OneToManyRelationship with OrderProduct
	 * and Review
	 */
	
	
	@OneToMany(mappedBy="product", cascade = CascadeType.ALL, orphanRemoval=true)
	private List<OrderProduct> items = new ArrayList<>();
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id")
	private Category category;
	
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL)
	Set<Review> review = new HashSet<>();

	/**
	 * Generate empty and parameterized constructors
	 */
	public Product() {
		super();
	}
	
	
	public Product(String name, String color, int price, List<OrderProduct> items, Category category,
			Set<Review> review) {
		super();
		this.name = name;
		this.color = color;
		this.price = price;
		this.items = items;
		this.category = category;
		this.review = review;
	}


	/**
	 * Generate Getters and Setters for attributes
	 * @return
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Review> getReview() {
		return review;
	}

	public void setReview(Set<Review> review) {
		this.review = review;
	}
	
	
	public List<OrderProduct> getItems() {
		return items;
	}


	public void setItems(List<OrderProduct> items) {
		this.items = items;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", color=" + color + ", price=" + price 
				+ ", category=" + category + ", review=" + review + "]";
	}

	/**
	 * Override hashCode and equals for testing
	 */
	
	
	
	
	
	
	
}
