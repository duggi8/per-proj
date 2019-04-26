package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserContactRepo;
import com.example.demo.entity.User;
import com.example.demo.entity.UserContact;

@RequestMapping("/rest/usercontact")
@RestController
public class UserContactResource {

	@Autowired
	UserContactRepo repo;
	
	@GetMapping("/all")
	 public List<UserContact> getUserContact(){
		 return repo.findAll(); 
	 }
	
	@GetMapping("/update/{name}")
	 public List<UserContact> updateUserContact(@PathVariable String name){
		UserContact userContact = new UserContact();
		User user  = new User();
		user.setName(name).setSalary(1000).setTeamName("dev");
		userContact.setPhoneNo(123432456).setUser(user);
		repo.save(userContact);
		return repo.findAll();
	 }
}
