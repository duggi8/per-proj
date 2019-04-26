package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;

	@Override
	public List<User> getUsers() {
		return userDao.getUserDetails();
	}

	@Override
	public List<User> createUsers(List<User> users) {
		return userDao.createUsers(users);
	}
	
	

}
