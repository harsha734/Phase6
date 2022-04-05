package com.foodbox.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.exception.AccessForbiddenException;
import com.foodbox.exception.CustomerNotFoundException;
import com.foodbox.exception.UserCreationError;
import com.foodbox.pojo.Customer;
import com.foodbox.pojo.User;
import com.foodbox.repository.CustomerRepository;
import com.foodbox.service.IUserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	IUserService userService;
	@Autowired
	CustomerRepository customerRepository;

	@PostMapping("/adduser")
	public User addUser(@RequestBody User user)
			throws AccessForbiddenException, CustomerNotFoundException, UserCreationError {
		
		if (user.getRole().equalsIgnoreCase("CUSTOMER")) {
			Customer customer = new Customer(user.getUsername(), null, null, null, user.getPassword());
			logger.info("-----------------Customer Added---------------------");
			customerRepository.saveAndFlush(customer);
			user.setCustomer(customer);
		}
		logger.info("-----------------User Added---------------------");
		return userService.addUser(user);
	}

	
	@DeleteMapping("/removeuser")
	public User removeUser(@RequestBody User user) throws AccessForbiddenException {
		
		logger.info("--------------------User Deleted------------------");
		return userService.removeUser(user);
	}
}