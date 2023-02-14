package com.samples.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	@NotBlank
	private String userName;
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,}$",message = "Min 1 uppercase letter.\r\n Min 1 lowercase letter.\r\n Min 1 special character.\r\n Min 1 number.\r\n Min 8 characters.")
	private String password;
	@NotBlank
	@Email
	private String email;
}
