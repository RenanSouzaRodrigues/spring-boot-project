package com.renansouza.sbp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renansouza.sbp.entities.Category;
import com.renansouza.sbp.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> getAllCategorys() {
		List<Category> orderList = service.findAll();
		return ResponseEntity.ok().body(orderList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Integer id) {
		Category order = service.findById(id);
		return ResponseEntity.ok().body(order);
	}
}
