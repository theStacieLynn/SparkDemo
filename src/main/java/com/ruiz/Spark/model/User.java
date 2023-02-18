package com.ruiz.Spark.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;
/**
 * 
 * @author s_lyn
 * Stacie Ruiz
 */
@Entity
public class User {
	/**
	 * Create field/attributes for the User entity
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	private String fName;
	
	private String lName;
	
	@Column(nullable = false, unique=true)
	private String email;
	

	private String password;
	

	
	/**
	 * Establish relationships with other entities
	 * Users has a one to many relationship with the 
	 * Order and Review entities
	 * 
	 */
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
	Set<OrderOriginal> orders = new HashSet<>();
	
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Review> reviews = new HashSet<>();
	/**
	 * Generate empty and parameterized constructors
	 */
	public User() {
		super();
	}
	
	
	public User(String fName, String lName, String email, String password, Set<OrderOriginal> orders,
			Set<Review> reviews) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
	
		this.orders = orders;
		this.reviews = reviews;
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


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Set<OrderOriginal> getOrders() {
		return orders;
	}


	public void setOrders(Set<OrderOriginal> orders) {
		this.orders = orders;
	}


	public Set<Review> getReviews() {
		return reviews;
	}


	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", password="
				+ password + ", orders=" + orders + ", reviews=" + reviews + "]";
	}


	/**
	 * Override hashCode and equals for testing
	 */
	@Override
	public int hashCode() {
		return Objects.hash(email, fName, id, lName, orders, password, reviews);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return  Objects.equals(email, other.email)
				&& Objects.equals(fName, other.fName) && Objects.equals(id, other.id)
				&& Objects.equals(lName, other.lName) && Objects.equals(orders, other.orders)
				&& Objects.equals(password, other.password) && Objects.equals(reviews, other.reviews);
	}


}
