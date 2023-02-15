package com.ruiz.Spark.model;



import java.util.Objects;

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
	public Review() {
		super();
	}
	public Review(String message, int rating, User user, Product product) {
		super();
		this.message = message;
		this.rating = rating;
		this.user = user;
		this.product = product;
	}
	/**
	 * create getters and setters
	 * @return
	 */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	@Override
	public String toString() {
		return "Review [id=" + id + ", message=" + message + ", rating=" + rating + ", user=" + user + ", product="
				+ product + "]";
	}
	
	/**
	 * Override hashCode and equals for testing
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, message, product, rating, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		return Objects.equals(id, other.id) && Objects.equals(message, other.message)
				&& Objects.equals(product, other.product) && rating == other.rating && Objects.equals(user, other.user);
	}
	
	
	

	
}
