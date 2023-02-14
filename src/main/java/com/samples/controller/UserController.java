package com.samples.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samples.dto.UserDto;
import com.samples.response.Response;
import com.samples.service.UserService;

@RestController
@RequestMapping("/secure/auth")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/login")
	public ResponseEntity<Response> addUser(@RequestBody @Valid UserDto userDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.crerateUser(userDto));
	}
}
