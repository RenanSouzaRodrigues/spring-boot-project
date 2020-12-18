package com.renansouza.sbp.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renansouza.sbp.entities.Product;
import com.renansouza.sbp.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public Product findById(Integer id) {
		Optional<Product> product = productRepository.findById(id);
		return product.get();
	}
}
