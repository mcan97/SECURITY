package com.course.securitydemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.course.securitydemo.model.Gender;
import com.course.securitydemo.model.User;
import com.course.securitydemo.repository.UserRepository;

@Controller
public class RegisterController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/register")
	public String index(ModelMap map) {
		map.addAttribute("user", new User());
		map.addAttribute("genders", Gender.values());
		return "register";
	}

	@PostMapping("/register")
	public String create(@ModelAttribute("user") User user) {
		
		System.out.println(user);
		userRepository.save(user);
		return "redirect:/home";
	}

}
