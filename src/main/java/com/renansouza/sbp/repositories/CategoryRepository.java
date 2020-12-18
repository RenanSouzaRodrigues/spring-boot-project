package com.renansouza.sbp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.renansouza.sbp.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {}