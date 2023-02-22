package com.ruiz.Spark.repositorytests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import com.ruiz.Spark.model.Product;
import com.ruiz.Spark.repository.ProductRepository;


@SpringBootTest
class RepoTests {
	
	@Autowired
	private ProductRepository productRepository;
	

	
	@Test
	public void getProductsByCategory() {
		List<Product> products = productRepository.findByCategory("eye");
		Assertions.assertThat(products.size()).isGreaterThan(0);
	}

	
}
