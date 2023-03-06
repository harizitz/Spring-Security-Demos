package com.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basic.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
