package com.renansouza.sbp.config;

import java.time.Instant;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.renansouza.sbp.entities.Category;
import com.renansouza.sbp.entities.Order;
import com.renansouza.sbp.entities.OrderItem;
import com.renansouza.sbp.entities.Product;
import com.renansouza.sbp.entities.User;
import com.renansouza.sbp.entities.enums.OrderStatus;
import com.renansouza.sbp.repositories.CategoryRepository;
import com.renansouza.sbp.repositories.OrderItemRepository;
import com.renansouza.sbp.repositories.OrderRepository;
import com.renansouza.sbp.repositories.ProductRepository;
import com.renansouza.sbp.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		User newUser1 = new User(null, "Renan Souza", "rubro1992@gmail.com", "1197988990", "789789rrr");
		userRepository.saveAll(Arrays.asList(newUser1));
		
		Order newOrder1 = new Order(null, newUser1, Instant.parse("2020-12-15T13:11:00Z"), OrderStatus.CANCELED);
		Order newOrder2 = new Order(null, newUser1, Instant.parse("2020-12-16T22:12:00Z"), OrderStatus.DELIVERED);
		Order newOrder3 = new Order(null, newUser1, Instant.parse("2020-12-17T23:13:00Z"), OrderStatus.WAITING_PAYMENT);
		Order newOrder4 = new Order(null, newUser1, Instant.parse("2020-12-17T23:13:00Z"), OrderStatus.PAID);
		orderRepository.saveAll(Arrays.asList(newOrder1, newOrder2, newOrder3, newOrder4));
		
		Category eletronics = new Category(null, "Electronics");
		Category books = new Category(null, "Books");
		Category computers = new Category(null, "Computers");
		categoryRepository.saveAll(Arrays.asList(eletronics, books, computers));
		
		Product newProduct1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		newProduct1.getCategories().add(books);
		
		Product newProduct2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		newProduct2.getCategories().addAll(Arrays.asList(eletronics, computers));
		
		Product newProduct3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		newProduct3.getCategories().addAll(Arrays.asList(eletronics, computers));
		
		Product newProduct4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		newProduct4.getCategories().addAll(Arrays.asList(eletronics, computers));
		
		Product newProduct5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		newProduct5.getCategories().add(books);
		
		productRepository.saveAll(Arrays.asList(newProduct1, newProduct2, newProduct3, newProduct4, newProduct5));
		
		OrderItem orderItem1 = new OrderItem(newOrder1, newProduct5, 2, newProduct5.getPrice());
		OrderItem orderItem2 = new OrderItem(newOrder2, newProduct3, 2, newProduct3.getPrice());
		OrderItem orderItem3 = new OrderItem(newOrder1, newProduct2, 2, newProduct2.getPrice());
		OrderItem orderItem4 = new OrderItem(newOrder4, newProduct1, 2, newProduct1.getPrice());
		OrderItem orderItem5 = new OrderItem(newOrder3, newProduct4, 2, newProduct4.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3, orderItem4, orderItem5));
	}
}