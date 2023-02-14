package com.ruiz.Spark.model;



import jakarta.persistence.*;

@Entity
public class Review {
	/**
	 * Creating fields for the review entity
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String message;
	
	@Column(nullable=false)
	private int rating;
	
	/**
	 * Establish the relationship
	 * Review has a ManyToOne relationship
	 * with User and Product
	 */
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	/**
	 * Generate empty and parameterized constructors
	 */

	
}
