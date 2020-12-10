package com.renansouza.sbp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renansouza.sbp.entities.User;
import com.renansouza.sbp.repositories.UserRepository;


@Service // define a classe como um service do spring, possibilitando a injeção de dependencias
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.get();
	}
}
