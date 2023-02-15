package com.ruiz.Spark.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;


@Entity
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private LocalDateTime date;
	@Column
	private double total;
	
	@ManyToMany
	@JoinTable(
			name = "oder_product",
			joinColumns = @JoinColumn(name="order_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id"))	
	private Set<Product> products = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id")
	private User user;
	/**
	 * Generate empty and parameterized constructors
	 */
	public Order() {
		super();
	}

	public Order(LocalDateTime date, double total, Set<Product> products, User user) {
		super();
		this.date = date;
		this.total = total;
		this.products = products;
		this.user = user;
	}
/**
 * Create getters and setters
 * @return
 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", date=" + date + ", total=" + total + ", products=" + products + ", user=" + user
				+ "]";
	}
	/**
	 * Override hashCode and equals for testing
	 */
	@Override
	public int hashCode() {
		return Objects.hash(date, id, products, total, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(date, other.date) && Objects.equals(id, other.id)
				&& Objects.equals(products, other.products)
				&& Double.doubleToLongBits(total) == Double.doubleToLongBits(other.total)
				&& Objects.equals(user, other.user);
	}
	
	
}
