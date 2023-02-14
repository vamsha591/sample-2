package com.samples.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samples.dto.UsersPetDto;
import com.samples.entity.Pet;
import com.samples.entity.PetsHistory;
import com.samples.entity.User;
import com.samples.entity.UsersPet;
import com.samples.exception.ResourceNotFoundException;
import com.samples.repository.PetRespository;
import com.samples.repository.PetsHistoryRepository;
import com.samples.repository.UserRepository;
import com.samples.repository.UsersPetRepository;
import com.samples.response.Response;
import com.samples.service.UsersPetService;

@Service
public class UsersPetServiceImpl implements UsersPetService {
	@Autowired
	private UsersPetRepository usersPetRepository;
	@Autowired
	private PetRespository petRespository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PetsHistoryRepository petsHistoryRepository;

	@Override
	public Response purchase(UsersPetDto usersPetDto) {
		Pet pet = petRespository.findById(usersPetDto.getPetId()).orElseThrow(
				() -> new ResourceNotFoundException("pet with id:" + usersPetDto.getPetId() + " not found"));
		User user = userRepository.findById(usersPetDto.getUserId()).orElseThrow(
				() -> new ResourceNotFoundException("User with id:" + usersPetDto.getUserId() + " not found"));
		if (pet.getQuantity() - usersPetDto.getQuentitySolid() >= 0) {
			pet.setQuantity(pet.getQuantity() - usersPetDto.getQuentitySolid());
			petRespository.save(pet);
			petsHistoryRepository.save(PetsHistory.builder().petId(pet.getPetId())
					.quentitySolid(usersPetDto.getQuentitySolid()).solidDate(LocalDate.now()).build());
			usersPetRepository.save(UsersPet.builder().petId(pet.getPetId()).userId(user.getUserId()).build());
			return new Response("Successfully transaction");
		}
		return new Response("Transaction failed");
	}

	@Override
	public List<UsersPet> purchaseHistory(int userId) {
		return usersPetRepository.findByUserId(userId);

	}

}
