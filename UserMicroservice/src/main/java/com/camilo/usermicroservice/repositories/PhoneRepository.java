package com.camilo.usermicroservice.repositories;

import com.camilo.usermicroservice.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long>{

}
