package com.samples.service;

import java.util.List;

import com.samples.dto.UsersPetDto;
import com.samples.entity.UsersPet;
import com.samples.response.Response;

public interface UsersPetService  {
	Response purchase(UsersPetDto usersPetDto);
	List<UsersPet> purchaseHistory(int userId);
}
