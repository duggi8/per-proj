package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrderRepo;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepo repo;
	
	@Override
	public List<Order> saveAll(List<Order> list) {
		return repo.saveAll(list);
	}

}
