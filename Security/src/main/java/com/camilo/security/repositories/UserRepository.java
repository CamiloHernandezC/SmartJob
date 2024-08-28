package com.camilo.security.repositories;

import java.util.Optional;

import com.camilo.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByEmail(String username);

}
