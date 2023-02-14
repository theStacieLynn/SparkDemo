package com.ruiz.Spark.model;

import jakarta.persistence.*;

@Entity
@Table
public class User {
	
	private Long id;
	private String fName;
	private String lName;
	private String email;
	private String password;
	private String address;
}
