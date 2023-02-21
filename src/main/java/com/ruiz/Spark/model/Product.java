package com.ruiz.Spark.model;




import java.util.List;

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

	private String name;

	private String color;

	private int price;
	
	/**
	 * Establish relationship with the other entities
	 * Product has a ManyToOne relationship with Category
	 * Product has a OneToManyRelationship with OrderProduct
	 * and Review
	 */
	
	
//	@OneToMany(mappedBy="product", cascade = CascadeType.ALL, orphanRemoval=true)
//	private List<OrderProduct> items = new ArrayList<>();
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id")
	private Category category;


	/**
	 * Generate empty and parameterized constructors
	 */
	public Product() {
		
	}
	public Product(String name) {
		this.name= name;
	}
	
	public Product(String name, String color, int price, Category category) {
		super();
		this.name = name;
		this.color = color;
		this.price = price;
		this.category = category;
	
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


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", color=" + color + ", price=" + price 
				+ ", category=" + category  + "]";
	}

	/**
	 * Override hashCode and equals for testing
	 */
	
	
	
	
	
	
	
}
