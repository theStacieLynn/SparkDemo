package com.ruiz.Spark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruiz.Spark.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
}
