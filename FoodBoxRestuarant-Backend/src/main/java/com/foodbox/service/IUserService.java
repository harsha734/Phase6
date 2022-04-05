package com.foodbox.service;

import com.foodbox.exception.UserCreationError;
import com.foodbox.pojo.User;

public interface IUserService {

	public User addUser(User user) throws UserCreationError;

	public User removeUser(User user);
}
