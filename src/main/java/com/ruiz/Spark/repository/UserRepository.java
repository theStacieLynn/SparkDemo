package com.ruiz.Spark.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ruiz.Spark.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
	
}
