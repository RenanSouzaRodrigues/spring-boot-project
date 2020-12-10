package com.renansouza.sbp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renansouza.sbp.entities.User;
import com.renansouza.sbp.services.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> userList = service.findAll();
		return ResponseEntity.ok().body(userList);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id)
	{
		User user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
}
