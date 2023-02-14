package com.samples.service;

import com.samples.dto.UserDto;
import com.samples.response.Response;

public interface UserService {
	Response crerateUser(UserDto userDto);
}
