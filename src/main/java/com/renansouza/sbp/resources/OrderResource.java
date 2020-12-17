package com.renansouza.sbp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renansouza.sbp.entities.Order;
import com.renansouza.sbp.services.OrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderResource {
	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> getAllOrders() {
		List<Order> orderList = service.findAll();
		return ResponseEntity.ok().body(orderList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable Integer id) {
		Order order = service.findById(id);
		return ResponseEntity.ok().body(order);
	}
}
