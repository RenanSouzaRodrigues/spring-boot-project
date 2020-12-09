package com.renansouza.sbp.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.renansouza.sbp.entities.User;
import com.renansouza.sbp.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User newUser1 = new User(null, "Renan Souza", "rubro1992@gmail.com", "1197988990", "789789rrr");
		User newUser2 = new User(null, "Artur Maschietto", "artur@gmail.com", "1197988990", "tuin-matador");
		
		userRepository.saveAll(Arrays.asList(newUser1, newUser2));
	}
}
