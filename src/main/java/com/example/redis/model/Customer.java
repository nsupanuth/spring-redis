package com.example.redis.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import javax.validation.constraints.NotNull;

@Data
@RedisHash(value = "customer", timeToLive = 60)
public class Customer {

	@Id
	@NotNull
	private String username;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private Integer age;
	@NotNull
	private String email;

	@TimeToLive
	private Long expiration;

	public Customer() {}

	public Customer(@NotNull String username, @NotNull String firstName, @NotNull String lastName, @NotNull Integer age, @NotNull String email) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
	}

}
