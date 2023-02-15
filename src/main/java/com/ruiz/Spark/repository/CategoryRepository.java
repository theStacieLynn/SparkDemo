package com.ruiz.Spark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ruiz.Spark.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}
