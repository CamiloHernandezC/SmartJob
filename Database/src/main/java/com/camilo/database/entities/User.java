package com.camilo.database.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "users")
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(columnDefinition = "UUID")
	private UUID id;
	@NotNull
	private String name;
	@NotNull
	private String email;
	@NotNull
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Phone> phones;
	@NotNull
	@Column(name="is_active")
	private Boolean isActive;
	@NotNull
	@Column(name="last_login")
	private Date lastLogin;
	@NotNull
	@Column(name="created_at")
	private Date createdAt;
	@NotNull
	@Column(name="updated_at")
	private Date updatedAt;
}
