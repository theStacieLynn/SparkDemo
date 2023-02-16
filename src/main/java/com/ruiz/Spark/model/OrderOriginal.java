package com.ruiz.Spark.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;


@Entity
@Table
public class OrderOriginal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	LocalDateTime date = LocalDateTime.now();
	@Column
	private double total;
	
	
	/**
	 * Establish relationship with other entities
	 * 
	 */
	@OneToMany(mappedBy="order", cascade = CascadeType.ALL, orphanRemoval=true)
	private List<OrderProduct> items = new ArrayList<>();
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id", referencedColumnName="id")
	private User user;
	
	
	
	
	/**
	 * Generate empty and parameterized constructors
	 */
	public OrderOriginal() {
		super();
	}


public OrderOriginal(LocalDateTime date, double total, List<OrderProduct> items, User user) {
		super();
		this.date = date;
		this.total = total;
		this.items = items;
		this.user = user;
	}


/**
 * Create getters and setters
 * @return
 */

	public Long getId() {
		return id;
	}

	public List<OrderProduct> getItems() {
	return items;
}


	public void setItems(List<OrderProduct> items) {
	this.items = items;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", date=" + date + ", total=" + total + " user=" + user
				+ "]";
	}
	/**
	 * Override hashCode and equals for testing
	 */

	
	

	@Override
	public int hashCode() {
		return Objects.hash(date, id, items, total, user);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderOriginal other = (OrderOriginal) obj;
		return Objects.equals(date, other.date) && Objects.equals(id, other.id) && Objects.equals(items, other.items)
				&& Double.doubleToLongBits(total) == Double.doubleToLongBits(other.total)
				&& Objects.equals(user, other.user);
	}
	
	
	
}
