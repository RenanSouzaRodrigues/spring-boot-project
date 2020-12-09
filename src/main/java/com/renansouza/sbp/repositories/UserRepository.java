package com.renansouza.sbp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renansouza.sbp.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {}
