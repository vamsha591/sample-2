package com.samples.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samples.entity.Pet;

public interface PetRespository extends JpaRepository<Pet, Integer> {
	List<Pet> findByPetNameContains(String petName);
}
