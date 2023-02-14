package com.ruiz.Spark.model;

import jakarta.persistence.*;

@Entity
public class Product {
	
	private Long id;
	private String name;
	private String color;
	private int price;

}
