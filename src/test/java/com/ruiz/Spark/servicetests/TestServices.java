package com.ruiz.Spark.servicetests;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.ruiz.Spark.dto.UserDto;
import com.ruiz.Spark.model.OrderOriginal;
import com.ruiz.Spark.model.Product;
import com.ruiz.Spark.model.User;
import com.ruiz.Spark.repository.OrderRepository;
import com.ruiz.Spark.repository.UserRepository;
import com.ruiz.Spark.service.OrderService;
import com.ruiz.Spark.service.ProductService;
import com.ruiz.Spark.service.UserService;

import jakarta.transaction.Transactional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional 
public class TestServices {
	
	
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderRepository orderRepository;
	

	
	
	/**
	 * tests the save user method in the service class
	 */
	@Test
	@Order(1)
	public void testSaveUser() {
		User user = new User("Stacie","Ruiz","test7@gmail.com","4568");
		userRepository.save(user);
		Assertions.assertThat(user.getId()).isGreaterThan(0);
	}
	
	@Test
	@Order(2)
	public void testGetListOfProducts() {
		List<Product> products = productService.getAllProducts();
		 Assertions.assertThat(products.size()).isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testDeleteOrder() { 
        OrderOriginal order = new OrderOriginal();
        orderService.deleteOrder(order);
        Assertions.assertThat(order.getId()).isNull();
    }

}
