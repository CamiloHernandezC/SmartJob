package com.camilo.usermicroservice.repositories;

import java.util.Optional;

import com.camilo.usermicroservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByEmail(String email);
}
