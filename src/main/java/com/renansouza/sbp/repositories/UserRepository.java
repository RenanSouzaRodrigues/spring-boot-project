package com.renansouza.sbp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.renansouza.sbp.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {}