package com.camilo.usermicroservice.converters;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.camilo.usermicroservice.DTO.UserDTO;
import com.camilo.usermicroservice.entities.Phone;
import com.camilo.usermicroservice.entities.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {

	public UserDTO toDTO(final User User) {
		final ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(User, UserDTO.class);
	}

	public List<UserDTO> toDTO(final List<User> Users) {
		List<UserDTO> resultDTO = new ArrayList<>();
		final ModelMapper modelMapper = new ModelMapper();
		for (User User : Users) {
			resultDTO.add(modelMapper.map(User, UserDTO.class));
		}
		return resultDTO;
	}

	public User toEntity(final UserDTO dto) {
		final ModelMapper modelMapper = new ModelMapper();
		User user = modelMapper.map(dto, User.class);
		if(user.getPhones() != null) {
			final List<Phone> phones = user.getPhones().stream()
					.map(phoneDTO -> {
						Phone phone = modelMapper.map(phoneDTO, Phone.class);
						phone.setUser(user);
						return phone;
					})
					.collect(Collectors.toList());
			user.setPhones(phones);
		}
		return user;
	}
}
