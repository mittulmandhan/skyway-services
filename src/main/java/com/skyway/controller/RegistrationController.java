package com.skyway.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skyway.dto.UserDto;
import com.skyway.persistence.model.User;
import com.skyway.service.UserService;
import com.skyway.validation.EmailExistsException;

@RestController
public class RegistrationController {

	@Autowired
	private UserService userService;

	@PostMapping("/user/registration")
	public ResponseEntity<?> registerUserAccount(@RequestBody @Valid UserDto accountDto) throws EmailExistsException {

		User registerNewUserAccount = userService.registerNewUserAccount(accountDto);

		return new ResponseEntity<>(registerNewUserAccount, HttpStatus.CREATED);
	}

}
