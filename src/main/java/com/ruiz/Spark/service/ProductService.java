package com.ruiz.Spark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruiz.Spark.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
}
