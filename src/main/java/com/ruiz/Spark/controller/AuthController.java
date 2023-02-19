package com.ruiz.Spark.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.ruiz.Spark.dto.UserDto;
import com.ruiz.Spark.model.User;
import com.ruiz.Spark.service.UserService;

import jakarta.validation.Valid;

@Controller
public class AuthController {
	@Autowired
	UserService userService;
	

	
	
	@GetMapping("/login")
	public String login() {
		return "login";
		
	}
	
	@GetMapping("/home")
	public String getHomePage() {
		return "index";
	}
	
	/**
	 * This method gets and displays
	 * the account registration form
	 * @param model
	 * @return
	 */
	@GetMapping("/register")
	public String viewCreateAccount(Model model) {
		UserDto user = new UserDto();
		model.addAttribute("user",user);
		return "register";
	}

	@PostMapping("/register/save")
	public String createAccount(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model	) {
		User userExists = userService.findbyEmail(userDto.getEmail());
		if (userExists != null && userExists.getEmail() != null) {
			result.rejectValue(null , "Account already exists with this email");
		}
		if (result.hasErrors()) {
			model.addAttribute("user", userDto);
			return "/register";
		}
		userService.saveUser(userDto);
		return "redirect:/register?success";
	}
}
