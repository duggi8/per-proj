package com.example.demo.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;

@RestController
public class OrderResource {

	@Autowired
	OrderService orderService;
	
	@Autowired
	UserService userService;
	
		
		@PostMapping("/create")
		public List<Order> createOrder(@RequestParam("id") Integer i) throws ResourceNotFoundException {
			User u = userService.findById(i).orElseThrow(()-> new ResourceNotFoundException("Resource not found for Id- " + i));
			Order o1 = new Order();
			o1.setItemName("TV");
			o1.setUser(u);
			Order o2 = new Order();
			o2.setItemName("Cable");
			o2.setUser(u);
			Order[] o = {o1,o2};
			return orderService.saveAll(Arrays.asList(o));
		}
}
