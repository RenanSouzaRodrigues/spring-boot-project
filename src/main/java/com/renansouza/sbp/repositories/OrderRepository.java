package com.renansouza.sbp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.renansouza.sbp.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {}