package com.ruiz.Spark.servicetests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ruiz.Spark.model.Product;
import com.ruiz.Spark.repository.ProductRepository;
import com.ruiz.Spark.service.ProductService;


@DataJpaTest
class ProductServiceTests {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductRepository productRepository;
	
	private Product product = new Product("Eyeliner");
	
	@Test
	void testGetAllProducts() {
       List<Product> products = productRepository.findAll();
       Assertions.assertThat(products.size()).isGreaterThan(0);
	}

}
