package com.ruiz.Spark.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Order {

	private Long id;
	private Date date;
	private int total;
}
