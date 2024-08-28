package com.camilo.security.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
public class User {

	@Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(columnDefinition = "UUID")
	private UUID id;
	private String name;
	private String email;
	private String password;
	private Date createdAt;
	private Date updatedAt;
	private Boolean isActive;
	private Date lastLogin;

}