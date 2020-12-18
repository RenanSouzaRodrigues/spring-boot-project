package com.renansouza.sbp.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.renansouza.sbp.entities.Order;
import com.renansouza.sbp.entities.User;
import com.renansouza.sbp.entities.enums.OrderStatus;
import com.renansouza.sbp.repositories.OrderRepository;
import com.renansouza.sbp.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User newUser1 = new User(null, "Renan Souza", "rubro1992@gmail.com", "1197988990", "789789rrr");
		userRepository.saveAll(Arrays.asList(newUser1));
		
		Order newOrder1 = new Order(null, newUser1, Instant.parse("2020-12-15T13:11:00Z"), OrderStatus.CANCELED);
		Order newOrder2 = new Order(null, newUser1, Instant.parse("2020-12-16T22:12:00Z"), OrderStatus.DELIVERED);
		Order newOrder3 = new Order(null, newUser1, Instant.parse("2020-12-17T23:13:00Z"), OrderStatus.WAITING_PAYMENT);
		Order newOrder4 = new Order(null, newUser1, Instant.parse("2020-12-17T23:13:00Z"), OrderStatus.PAID);
		orderRepository.saveAll(Arrays.asList(newOrder1, newOrder2, newOrder3, newOrder4));
	}
}