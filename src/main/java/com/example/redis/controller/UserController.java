package com.example.redis.controller;

import com.example.redis.model.User;
import com.example.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> getAllCustomers() {
		return userService.getAllUsers();
	}

	@PostMapping
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

}
