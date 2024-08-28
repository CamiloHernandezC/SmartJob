package com.camilo.usermicroservice.services;

import java.util.List;
import java.util.Optional;

import com.camilo.usermicroservice.DTO.UserDTO;
import com.camilo.usermicroservice.converters.PhoneConverter;
import com.camilo.usermicroservice.entities.Phone;
import com.camilo.usermicroservice.entities.User;
import com.camilo.usermicroservice.repositories.UserRepository;
import com.camilo.usermicroservice.services.interfaces.UserServiceInterface;
import org.springframework.stereotype.Service;

import com.camilo.usermicroservice.converters.UserConverter;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServiceInterface {

	private final UserRepository repository;
	private final UserConverter userConverter;

	@Override
	@Transactional(readOnly = true)
	public List<UserDTO> all() {
		return userConverter.toDTO(repository.findAll());
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<UserDTO> findUserByEmail(String email) {
		Optional<User> user = repository.findByEmail(email);
		if(user.isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(userConverter.toDTO(user.get()));
	}

	@Override
	@Transactional
	public UserDTO save(final UserDTO newUser) {
		final User user = userConverter.toEntity(newUser);
		final User savedUser = repository.save(user);
		return userConverter.toDTO(savedUser);
	}

}
