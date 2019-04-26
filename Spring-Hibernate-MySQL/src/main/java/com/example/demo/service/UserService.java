package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
	
	public List<User> getUsers();
	
	public List<User> createUsers(List<User> users);

}
