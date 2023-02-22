package com.ruiz.Spark.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.ruiz.Spark.dto.UserDto;
import com.ruiz.Spark.model.User;
import com.ruiz.Spark.repository.UserRepository;



@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public User findbyEmail(String email) {
		
		return userRepository.findByEmail(email);
//		User user = userRepository.findByEmail(email);
//		if(user==null) {
//			throw new EntityNotFoundException("Email not found");
//		}
//		return user;
	}
	

	public void saveUser(UserDto userDto) {
		User user = new User();
		user.setfName(userDto.getfName());
		user.setlName(userDto.getlName());
		user.setEmail(userDto.getEmail());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		
		userRepository.save(user);
	}
}
