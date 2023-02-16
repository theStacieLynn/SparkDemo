package com.ruiz.Spark.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ruiz.Spark.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findByName(String name);
	Optional<Product> findByColor(String color);
	Optional<Product> findByPrice(Double price);
}
