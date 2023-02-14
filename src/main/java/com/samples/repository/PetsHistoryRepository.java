package com.samples.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samples.entity.PetsHistory;

public interface PetsHistoryRepository extends JpaRepository<PetsHistory, Integer>{
	List<PetsHistory> findByPetId(int petId);
}
