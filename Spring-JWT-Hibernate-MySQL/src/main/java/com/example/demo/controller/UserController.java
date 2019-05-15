package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	/*	@Autowired
		UserService service;
		
		@GetMapping("/users")
		public ListUsers getUsers(){
			ListUsers list = new ListUsers();
			list.setUserList(service.getUsers());
			return list;  
		}
		
		@PostMapping("/users")
		public ListUsers createUsers(@RequestBody List<User> users ){
			ListUsers list = new ListUsers();
			list.setUserList(service.createUsers(users));
			return list;
		}*/
}
