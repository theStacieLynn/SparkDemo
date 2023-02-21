package com.ruiz.Spark.repositorytests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ruiz.Spark.model.Product;
import com.ruiz.Spark.repository.ProductRepository;
import com.ruiz.Spark.repository.UserRepository;

@DataJpaTest
class RepoTests {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	

	@Test
	void testGetAllProducts() {
       List<Product> products = productRepository.findAll();
       Assertions.assertThat(products.size()).isGreaterThan(0);
	}
	
	
	@ParameterizedTest
	void findProductByCategory(String category) {
		List<Product> products = productRepository.findByCategory(category);
		Assertions.assertThat(products.size()).isGreaterThan(0);
	}

}
