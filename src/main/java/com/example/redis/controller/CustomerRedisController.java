package com.example.redis.controller;

import com.example.redis.model.Customer;
import com.example.redis.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerRedisController {

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@PostMapping
	public Customer saveCustomers(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@GetMapping("/{username}")
	public Customer getById(@PathVariable("username") String username) {
		Optional<Customer> customer = customerRepository.findById(username);
		return customer.orElse(null);
	}

}
