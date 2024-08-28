package com.camilo.usermicroservice.controllers;

import java.util.List;

import com.camilo.usermicroservice.DTO.UserDTO;
import com.camilo.usermicroservice.exceptions.EmailTakenException;
import com.camilo.usermicroservice.services.interfaces.UserServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class UserController {
	
	private final UserServiceInterface service;

	@GetMapping("/users") 
	List<UserDTO> all() {
		return service.all();
	}
	
	@PutMapping("/users")
	UserDTO newUser(@RequestBody UserDTO newUser) {
		if(service.findUserByEmail(newUser.getEmail()).isPresent()) {
			throw new EmailTakenException();
		}
		return service.save(newUser);
	}
}
