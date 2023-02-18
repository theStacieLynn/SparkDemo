package com.ruiz.Spark.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ruiz.Spark.model.User;
import com.ruiz.Spark.service.UserService;

@Service
public class SecurityService implements UserDetailsService{
	@Autowired
	UserService userService;

	/**
	 * This method authenticates the user
	 * with their email and password
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userService.findbyEmail(email);
		
		if(user!=null) {
			return new org.springframework.security.core.userdetails
					.User(user.getEmail(), user.getPassword(),
							Collections.singleton(new SimpleGrantedAuthority("USER")));
		}else {
			throw new UsernameNotFoundException("Incorrect email or password, please try again.");
		}
	
	}

}
