package com.samples.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samples.entity.Pet;
import com.samples.repository.PetRespository;
import com.samples.service.PetService;
@Service
public class PetServiceImpl implements PetService {
	@Autowired
	private PetRespository petRespository;
	@Override
	public List<Pet> findAllPets(String name){
		
		return petRespository.findByPetNameContains(name);
	}
}
