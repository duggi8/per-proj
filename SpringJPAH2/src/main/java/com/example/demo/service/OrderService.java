package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Order;

public interface OrderService {

	public List<Order> saveAll(List<Order> list);
}
