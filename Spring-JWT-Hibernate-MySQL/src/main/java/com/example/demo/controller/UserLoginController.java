package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ApplicationUser;
import com.example.demo.repository.ApplicationUserRepository;

@RestController
@RequestMapping("/users")
public class UserLoginController {

	@Autowired
	private ApplicationUserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/sign-up")
	public void signUp(@RequestBody ApplicationUser user){
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		repo.save(user);
	}
	
	
}
