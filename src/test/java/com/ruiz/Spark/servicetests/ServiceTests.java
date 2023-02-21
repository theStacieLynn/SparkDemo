package com.ruiz.Spark.servicetests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ruiz.Spark.dto.UserDto;
import com.ruiz.Spark.model.OrderOriginal;
import com.ruiz.Spark.model.Product;
import com.ruiz.Spark.model.User;
import com.ruiz.Spark.repository.OrderRepository;
import com.ruiz.Spark.repository.ProductRepository;
import com.ruiz.Spark.repository.UserRepository;
import com.ruiz.Spark.service.OrderService;
import com.ruiz.Spark.service.ProductService;
import com.ruiz.Spark.service.UserService;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ServiceTests {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderRepository orderRepository;
	
	private Product product = new Product("Eyeliner","blue",12,null);

	private OrderOriginal order = new OrderOriginal();
	
	
	
	/**
	 * tests the save user method in the service class
	 */
	@Test
	@Order(1)
	void testSaveUser() {
		UserDto user = new UserDto("Stacie","Ruiz","123@gmail.com","4568");
		userService.saveUser(user);
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
        OrderOriginal order = orderRepository.findById(1L).get();
        orderService.deleteOrder(order);
        Assertions.assertThat(order).isNull();
    }


}
