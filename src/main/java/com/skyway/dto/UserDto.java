package com.skyway.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.skyway.interfaces.ValidEmail;
import com.skyway.validation.PasswordMatches;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@PasswordMatches
@Getter
@Setter
@NoArgsConstructor
public class UserDto {

	@NotNull
	@NotEmpty
	private String firstName;

	@NotNull
	@NotEmpty
	private String lastName;

	@NotNull
	@NotEmpty
	private String password;
	private String matchingPassword;

	@ValidEmail
	@NotNull
	@NotEmpty
	private String email;

	// standard getters and setters
}
