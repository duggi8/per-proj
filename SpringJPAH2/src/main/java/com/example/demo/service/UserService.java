package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;


public interface UserService {

	public List<User>findAll();
	
	public User create(User user);
	
	public Optional<User> findById(Integer i);
	
	public User save(User user);
	
	public void deleteById(Integer i);
}
