package com.samples.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samples.entity.UsersPet;

public interface UsersPetRepository extends JpaRepository<UsersPet, Integer> {
	List<UsersPet> findByUserId(int id);
}
