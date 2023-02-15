package com.ruiz.Spark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ruiz.Spark.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
