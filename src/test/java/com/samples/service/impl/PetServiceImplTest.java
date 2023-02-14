package com.samples.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.samples.entity.Pet;
import com.samples.repository.PetRespository;

@ExtendWith(SpringExtension.class)
public class PetServiceImplTest {
	@Mock
	PetRespository petRespository;
	@InjectMocks
	PetServiceImpl petServiceImpl;

	@Test
	void testFindAllPetsFirst() {
		String name = "DOG";
		List<Pet> pets = Arrays.asList(new Pet(1, "DOG", 5));
		Mockito.when(petRespository.findByPetNameContains(name)).thenReturn(pets);
		assertEquals(petServiceImpl.findAllPets(name), pets);
		assertEquals(petServiceImpl.findAllPets(name).size(), pets.size());
	}
	@Test
	void testFindAllPetsSecond() {
		String name="DOG";
		List<Pet>pets=Arrays.asList(new Pet(1, "CAT", 10));
		Mockito.when(petRespository.findByPetNameContains(name)).thenReturn(null);
		assertEquals(null,petServiceImpl.findAllPets(name));		
	}
}
