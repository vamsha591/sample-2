package com.samples.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samples.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);
}
