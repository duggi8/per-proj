package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepo;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Service("userService1")
public class UserServiceImpl1 implements UserService {

	@Autowired
	UserRepo repo;
	
	@Override
	public List<User> findAll() {
		
		List<User> users = repo.findAll();
		return users;
	}

	@Override
	public User create(User user) {
		User u = repo.save(user);
		return u;
	}

	public void printThis() {
		System.out.println("userService1");
	}

	@Override
	public Optional<User> findById(Integer i) {
		return repo.findById(i);
	}

	@Override
	public User save(User user) {
		repo.save(user);
		return null;
	}

	@Override
	public void deleteById(Integer i) {
		repo.deleteById(i);		
	}
}
