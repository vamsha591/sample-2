package com.samples.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.samples.dto.UserDto;
import com.samples.entity.User;
import com.samples.repository.UserRepository;
import com.samples.response.Response;

@ExtendWith(SpringExtension.class)
public class UserServiceImplTest {
	@Mock
	UserRepository userRepository;
	@InjectMocks
	UserServiceimpl userServiceimpl;
	@Test
	void testCrerateUserFirst() {
		UserDto userDto=new UserDto("Vamsha", "Vamsha@1234", "vamshaspoojary@gmail.com");
		Mockito.when(userRepository.findByEmail(userDto.getEmail())).thenReturn(null);
		Mockito.when(userRepository.save(User.builder().userName(userDto.getUserName()).password(userDto.getPassword()).email(userDto.getEmail()).build())).thenReturn(new User());
		assertEquals(userServiceimpl.crerateUser(userDto).getMessage(), new Response("Registered successfully").getMessage());
	}
	@Test
	void testCreateUserSecond() {
		UserDto userDto=new UserDto("Vamsha", "Vamsha@1234", "vamshaspoojary@gmail.com");
		User user=new User(1, "Vamsha","Vamsha@1234", "vamshaspoojary@gmail.com");
		Mockito.when(userRepository.findByEmail(userDto.getEmail())).thenReturn(user);
		assertEquals(userServiceimpl.crerateUser(userDto).getMessage(), new Response("Logged successfully").getMessage());
	}
	@Test
	void testCreateUserThird() {
		UserDto userDto=new UserDto("Vamsha", "Vamsha@123", "vamshaspoojary@gmail.com");
		User user=new User(1, "Vamsha","Vamsha@1234", "vamshaspoojary@gmail.com");
		Mockito.when(userRepository.findByEmail(userDto.getEmail())).thenReturn(user);
		assertEquals(userServiceimpl.crerateUser(userDto).getMessage(), new Response("incorrect user or password").getMessage());
	}
}
