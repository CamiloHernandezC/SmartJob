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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserControllerTests {
/*
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

	private static final String TEST_USER_NAME = "testUserName";
	private static final String WRONG_TEST_USER_NAME = "wrong user name";
	private final User userMock = new User(999L, "testUser", null, TEST_USER_NAME, "testPassword", null);
	private final UserDTO userDTOMock = new UserDTO(999L, "testUser", null, TEST_USER_NAME, "testPassword", null);

	private final UserDTO updatedUserDTOMock = new UserDTO(999L, "updatedName", "updatedSpeudonim", TEST_USER_NAME, "updatedPassword", null);

	@Test
	void findAll() {
		when(repository.findAll()).thenReturn(Collections.singletonList(userMock));
		final List<UserDTO> users = userController.all();
		assertEquals(users.size(),1);
		assertEquals(users.get(0).getUsername(),TEST_USER_NAME);
	}

	@Test
	void saveNewUser() {
		when(repository.save(Mockito.any(User.class))).thenReturn(userMock);
		final UserDTO resp = userController.newUser(userDTOMock);
		assertEquals(resp,userDTOMock);
	}
	
	@Test
	void saveNewUserUsernameTakenError() {
		when(repository.findByUsername(TEST_USER_NAME)).thenReturn(Optional.of(userMock));
		try {
			userController.newUser(userDTOMock);
		}catch (EmailTakenException e) {
			assertEquals(e.getMessage(),TEST_USER_NAME + " username is already in use, please register with another one");
		}
	}

	@Test
	void getOneUser() {
		when(repository.findByUsername(TEST_USER_NAME)).thenReturn(Optional.of(userMock));
		final UserDTO resp = userController.getUser(TEST_USER_NAME);
		assertEquals(resp,userDTOMock);
	}

	@Test
	void getOneUserUserNotFoundError() {
		when(repository.findByUsername(WRONG_TEST_USER_NAME)).thenReturn(Optional.empty());
		try {
			userController.getUser(TEST_USER_NAME);
		}catch (UserNotFoundException ex){
			assertEquals(ex.getMessage(),"Could not find user "+ TEST_USER_NAME);
		}
	}
	
	@Test
	void deleteUser() {
		when(repository.findByUsername(TEST_USER_NAME)).thenReturn(Optional.of(userMock));
		userController.deleteUser(TEST_USER_NAME, TEST_USER_NAME);
	}
	
	@Test
	void deleteUserUnauthorizedException() {
		try {
			userController.deleteUser(TEST_USER_NAME, WRONG_TEST_USER_NAME);
		}catch (UnauthorizedException ex){
			assertEquals(ex.getMessage(),"Your are not autorized to use this service because you are trying to delete a user that don't belongs to you");
		}
	}
	
	@Test
	void updateUser() {
		when(repository.findByUsername(TEST_USER_NAME)).thenReturn(Optional.of(userMock));
		when(repository.save(Mockito.any())).then(o -> o.getArgument(0));
		final UserDTO updatedUser = userController.updateUser(updatedUserDTOMock, TEST_USER_NAME);
		assertEquals(updatedUserDTOMock, updatedUser);
	}
	
	@Test
	void updateUserNotAuthorizedError() {
		try {
			userController.updateUser(updatedUserDTOMock, WRONG_TEST_USER_NAME);
		}catch (UnauthorizedException ex){
			assertEquals(ex.getMessage(),"Your are not autorized to use this service because you are trying to update a user that don't belongs to you");
		}
	}
	
	@Test
	void updateUserUserNotFoundError() {
		when(repository.findByUsername(TEST_USER_NAME)).thenReturn(Optional.empty());
		try {
			userController.updateUser(updatedUserDTOMock, TEST_USER_NAME);
		}catch (UserNotFoundException e) {
			assertEquals(e.getMessage(),"Could not find user " + TEST_USER_NAME);
		}
	}
*/
}
