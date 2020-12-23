package com.renansouza.sbp.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.renansouza.sbp.entities.Order;
import com.renansouza.sbp.entities.User;
import com.renansouza.sbp.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> userList = service.findAll();
		return ResponseEntity.ok().body(userList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id)
	{
		User user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping(value = "/{id}/orders")
	public ResponseEntity<List<Order>> findUserOrders(@PathVariable Integer id) {
		List<Order> orders = service.findUserOrdersByUserId(id);
		return ResponseEntity.ok().body(orders);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User newUser) {
		User newSavedUser = service.insert(newUser);
		return ResponseEntity.ok().body(newSavedUser);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update (@PathVariable Integer id, @RequestBody User user) {
		User userUpdated = service.update(id, user);
		return ResponseEntity.ok().body(userUpdated);
	}
}
