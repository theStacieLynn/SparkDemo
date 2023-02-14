package com.ruiz.Spark.model;

import java.util.ArrayList;
import java.util.List;


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
	

}
