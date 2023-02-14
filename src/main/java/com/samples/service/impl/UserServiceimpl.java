package com.samples.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.samples.dto.UserDto;
import com.samples.entity.User;
import com.samples.repository.UserRepository;
import com.samples.response.Response;
import com.samples.service.UserService;

@Service
public class UserServiceimpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Response crerateUser(UserDto userDto) {
		User user2 = userRepository.findByEmail(userDto.getEmail());
		if (user2 != null) {
			if (userDto.getUserName().equals(user2.getUserName())&&userDto.getPassword().equals(user2.getPassword()))
				return new Response("Logged successfully");
			return new Response("incorrect user or password");
		}
	
		userRepository.save(User.builder().userName(userDto.getUserName()).password(userDto.getPassword()).email(userDto.getEmail()).build());
		return new Response("Registered successfully");
	}

}
