package com.camilo.usermicroservice.controllers;

import com.camilo.usermicroservice.DTO.UserDTO;
import com.camilo.usermicroservice.entities.User;
import com.camilo.usermicroservice.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.camilo.usermicroservice.converters.UserConverter;
import com.camilo.usermicroservice.exceptions.EmailTakenException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserControllerTests {

	@Autowired
	private UserController userController;

	@MockBean
	private UserRepository repository;

	@Spy
	private UserConverter userConverter;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	private static final String TEST_USER_NAME = "test@user.com";

    private static final UUID uuid = UUID.randomUUID();

    private final User userMock =  User.builder()
            .id(uuid)
            .name("testUser")
            .email(TEST_USER_NAME)
            .password("testPassword")
            .build();
	private final UserDTO userDTOMock = UserDTO.builder()
            .id(uuid)
            .name("testUser")
            .email(TEST_USER_NAME)
            .password("testPassword")
            .build();

	@Test
	void findAll() {
		when(repository.findAll()).thenReturn(Collections.singletonList(userMock));
		final List<UserDTO> users = userController.all();
		assertEquals(users.size(),1);
		assertEquals(users.get(0).getEmail(),TEST_USER_NAME);
	}

	@Test
	void saveNewUser() {
		when(repository.save(Mockito.any(User.class))).thenReturn(userMock);
		final UserDTO resp = userController.newUser(userDTOMock);
		assertEquals(resp,userDTOMock);
	}
	
	@Test
	void saveNewUserEmailTakenError() {
		when(repository.findByEmail(TEST_USER_NAME)).thenReturn(Optional.of(userMock));
		try {
			userController.newUser(userDTOMock);
		}catch (EmailTakenException e) {
			assertEquals(e.getMessage(),"El correo ya registrado");
		}
	}
}
