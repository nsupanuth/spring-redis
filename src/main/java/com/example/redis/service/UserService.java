package com.example.redis.service;

import com.example.redis.model.User;
import com.example.redis.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepository;

	@Cacheable(value = "user")
	public List<User> getAllUsers() {
		log.info("Get all users");
		return userRepository.findAll();
	}

	@CacheEvict(value = "user", allEntries = true)
	public User addUser(User user) {
		return userRepository.save(user);
	}

}
