package com.ruiz.Spark.model;

import jakarta.persistence.*;

@Entity
public class Review {
	private Long id;
	private String message;
	private int rating;
}
