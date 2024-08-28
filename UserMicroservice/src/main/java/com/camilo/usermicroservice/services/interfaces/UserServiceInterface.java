package com.camilo.usermicroservice.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.camilo.usermicroservice.DTO.UserDTO;

public interface UserServiceInterface {

	List<UserDTO> all();

	Optional<UserDTO> findUserByEmail(String username);

	UserDTO save(UserDTO newUser);

}
