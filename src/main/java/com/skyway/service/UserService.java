package com.skyway.service;

import com.skyway.dto.UserDto;
import com.skyway.persistence.model.User;
import com.skyway.validation.EmailExistsException;

public interface UserService {

	User registerNewUserAccount(UserDto accountDto) throws EmailExistsException;

}
