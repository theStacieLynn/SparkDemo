package com.ruiz.Spark.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	
	/**
	 * Establish relationship with other entity
	 * Category has a OneToManyRelationship with
	 * Product
	 */
	@OneToMany(mappedBy = "category",cascade=CascadeType.ALL)
	private List<Product> products = new ArrayList<>();
	/**
	 * Generate empty and parameterized constructors
	 */

	public Category() {
		super();
	}
	public Category(String name, List<Product> products) {
		super();
		this.name = name;
		this.products = products;
	}
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
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", products=" + products + "]";
	}
	/**
	 * Override hashCode and equals for testing
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, name, products);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(products, other.products);
	}
	

}
