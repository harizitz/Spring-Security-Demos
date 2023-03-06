package com.securejwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securejwt.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
