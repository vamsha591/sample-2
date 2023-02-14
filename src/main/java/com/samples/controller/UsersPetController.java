package com.samples.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samples.dto.UsersPetDto;
import com.samples.entity.UsersPet;
import com.samples.response.Response;
import com.samples.service.UsersPetService;

@RequestMapping("/Users-Pet")
@RestController
public class UsersPetController {
	@Autowired
	private UsersPetService usersPetService;
	@PostMapping
	public ResponseEntity<Response> purchase(@RequestBody UsersPetDto usersPetDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usersPetService.purchase(usersPetDto));
	}
	@GetMapping("/{userId}")
	public ResponseEntity<List<UsersPet>> purchaseHistory(@PathVariable int userId) {
		return ResponseEntity.ok(usersPetService.purchaseHistory(userId));
		
	}
}
