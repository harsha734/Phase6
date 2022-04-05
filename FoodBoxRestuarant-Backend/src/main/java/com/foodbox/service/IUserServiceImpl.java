package com.foodbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.repoImpl.QueryClass;
import com.cg.mts.validator.InputValidator;
import com.foodbox.exception.UserCreationError;
import com.foodbox.pojo.User;
import com.foodbox.repository.UserRepository;

@Service
public class IUserServiceImpl implements IUserService {

	@Autowired
	UserRepository userrepo;

	@Autowired
	InputValidator validate;

	@Autowired
	QueryClass qcp;

	@Override
	public User addUser(User user) throws UserCreationError {
		if (!validate.usernameValidator(user.getUsername()))
			throw new UserCreationError("Check Username !!!!");
		if (!validate.passwordValidator(user.getPassword()))
			throw new UserCreationError("Cannot register this User with this password");
		return userrepo.saveAndFlush(user);
	}

	@Override
	public User removeUser(User user) {
		userrepo.delete(user);
		return user;
	}

}
