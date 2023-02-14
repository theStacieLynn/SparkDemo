package com.ruiz.Spark.model;

import java.util.HashSet;

import java.util.Set;

import jakarta.persistence.*;

@Entity
public class User {
	/**
	 * Create field/attributes for the User entity
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable =false)
	private String fName;
	
	@Column(nullable =false)
	private String lName;
	
	@Column(nullable = false, unique=true)
	private String email;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable =false)
	private String address;
	
	/**
	 * Establish relationships with other entities
	 * Users has a one to many relationship with the 
	 * Order and Review entities
	 * 
	 */
	
	@OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
	private Set<Order> orders = new HashSet<>();
	@OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
	private Set<Review> reviews = new HashSet<>();

	/**
	 * Generate empty and parameterized constructors
	 */
	


	/**
	 * Generate Getters and Setters for attributes
	 * @return
	 */



	/**
	 * Override hashCode and equals for testing
	 */


}
