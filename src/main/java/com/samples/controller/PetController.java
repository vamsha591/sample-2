package com.samples.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samples.entity.Pet;
import com.samples.service.PetService;

@RestController
@RequestMapping("/pet")
public class PetController {
	@Autowired
	private PetService petService;
	@GetMapping("/{name}")
	public ResponseEntity<List<Pet>> findAllPets(@PathVariable String name) {
	return ResponseEntity.ok(petService.findAllPets(name));	
}
	
}
