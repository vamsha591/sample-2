package com.samples.service;

import java.util.List;

import com.samples.entity.Pet;

public interface PetService {
	List<Pet> findAllPets(String name);
}
