package com.camilo.database.repositories;

import com.camilo.database.entities.Phone;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PhoneRepository extends PagingAndSortingRepository<Phone, Long>, JpaSpecificationExecutor<Phone>{

}
