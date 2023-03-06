package com.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basic.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
