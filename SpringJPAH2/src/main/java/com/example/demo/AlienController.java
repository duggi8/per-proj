package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.AlienRepo;
import com.example.demo.entity.Alien;

@Controller
@RequestMapping("/api")
public class AlienController {

	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/home")
	public String getHomePage(Alien alien) {
		return "home";
	}
	
	@RequestMapping("/alien")
	public String addAlien(@ModelAttribute("alien") Alien alien) {
		System.out.println(alien.getId());
		System.out.println(alien.getName());
		repo.save(alien);
		return "home";
	}
}
