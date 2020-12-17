package com.renansouza.sbp.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renansouza.sbp.entities.Order;
import com.renansouza.sbp.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;
	
	public OrderRepository getRepository() {
		return this.repository;
	}
	
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Integer id) {
		Optional<Order> order = repository.findById(id);
		return order.get();
	}
	
	
}
