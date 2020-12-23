package com.renansouza.sbp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renansouza.sbp.entities.Order;
import com.renansouza.sbp.entities.User;
import com.renansouza.sbp.repositories.UserRepository;


@Service // define a classe como um service do spring, possibilitando a injeção de dependencias
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public UserRepository getRepository() {
		return this.repository;
	}
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Integer id) {
		Optional<User> user = repository.findById(id);
		return user.get();
	}
	
	public List<Order> findUserOrdersByUserId(Integer id) {
		User user = this.findById(id);
		return user.getOrders();
	}
	
	public User insert(User newUser) {
		 return repository.save(newUser);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public User update(Integer id, User user) {
		User entity = repository.getOne(id);
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
		return repository.save(entity);
	}
}
