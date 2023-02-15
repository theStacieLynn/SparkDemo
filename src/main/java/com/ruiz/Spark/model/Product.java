package com.ruiz.Spark.model;


import java.util.HashSet;
import java.util.Objects;
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
	 * Product has a Many to Many relationship with order
	 * Product has a OneToManyRelationship with 
	 */
	@ManyToMany(mappedBy="products")
	private Set<Order> orders = new HashSet<>();
	
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
	
	public Product(String name, String color, int price, Set<Order> orders, Category category, Set<Review> review) {
		super();
		this.name = name;
		this.color = color;
		this.price = price;
		this.orders = orders;
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

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
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
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", color=" + color + ", price=" + price + ", orders=" + orders
				+ ", category=" + category + ", review=" + review + "]";
	}

	/**
	 * Override hashCode and equals for testing
	 */
	@Override
	public int hashCode() {
		return Objects.hash(category, color, id, name, orders, price, review);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(category, other.category) && Objects.equals(color, other.color)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(orders, other.orders) && price == other.price && Objects.equals(review, other.review);
	}
	
	
	
	
	
	
}
