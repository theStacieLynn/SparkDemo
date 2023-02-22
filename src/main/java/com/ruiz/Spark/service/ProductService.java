package com.ruiz.Spark.service;


import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ruiz.Spark.model.Product;
import com.ruiz.Spark.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	
	/**
	 * Method to get a list of all products
	 * @return
	 */
	public List<Product> getAllProducts(){
		//create a list to return
		List<Product> products = new ArrayList<Product>();
		productRepository.findAll().forEach(products::add);
		return products;
	}
	/**
	 * get product by id
	 * @return
	 */
	public Product getProductById(Long id){
		Product product = productRepository.findById(id).orElse(null);
		if(product==null) {
			throw new EntityNotFoundException("Order with id "+id+" is not found.");
		}
		return product;
	}
	
	/**
	 * This method gets a list of 
	 * products by category name
	 * @param category
	 * @return
	 */
	public List<Product> getProductsByCategory(String category){
		
		return productRepository.findByCategory(category);
	}
	
	/**
	 * Saves the product
	 * @param product
	 */
	public void save(Product product) {
		productRepository.save(product);
		
	}

	/**
	 * This method takes in an id 
	 * and a product and updates that
	 * product if it exists.
	 * @param id
	 * @param product
	 */
	public void updateProduct(Long id, Product product) {
		Optional<Product> productData = productRepository.findById(id);
		
		if(productData.isPresent()) {
			Product _product=productData.get();
			_product.setName(product.getName());
			_product.setColor(product.getColor());
			productRepository.save(_product);
		}
	}

}
