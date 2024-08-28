package com.camilo.usermicroservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(columnDefinition = "UUID")
	private UUID id;
	private String name;
	private String email;
	private String password;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Phone> phones;
	private Date createdAt;
	private Date updatedAt;
	private Boolean isActive;
	private Date lastLogin;

	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
		updatedAt = createdAt;
		lastLogin = createdAt;
		isActive = true;
	}
}