package com.renansouza.sbp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renansouza.sbp.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {}
