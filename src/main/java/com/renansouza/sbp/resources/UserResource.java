package com.renansouza.sbp.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renansouza.sbp.entities.User;

@RestController
@RequestMapping(value = "/user")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> getUser() {
		User newUser = new User(1L, "Renan Souza", "rubro1992@gmail.com", "11979889910", "bolado@123");
		return ResponseEntity.ok().body(newUser);
	}
}
