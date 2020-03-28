package com.skyway.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyway.dto.UserDto;
import com.skyway.persistence.dao.UserRepository;
import com.skyway.persistence.model.User;
import com.skyway.validation.EmailExistsException;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repository;

	@Transactional
	@Override
	public User registerNewUserAccount(UserDto accountDto) throws EmailExistsException {

		if (emailExist(accountDto.getEmail())) {
			throw new EmailExistsException("There is an account with that email adress: " + accountDto.getEmail());
		}
		
		User user = new User();
		
		user.setFirstName(accountDto.getFirstName());
		user.setLastName(accountDto.getLastName());
		user.setEmail(accountDto.getEmail());
		user.setPassword(accountDto.getPassword());
		
		
		repository.save(user);
		
		return null;
	}

	private boolean emailExist(String email) {
		User user = repository.findByEmail(email);
		if (user != null) {
			return true;
		}
		return false;
	}
}
