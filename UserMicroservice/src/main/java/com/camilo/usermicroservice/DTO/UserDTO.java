package com.camilo.usermicroservice.DTO;

import java.util.*;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
@ToString(exclude = {"password"})
@Builder
public class UserDTO {

	private UUID id;
	private String name;
	private String email;
	private String password;
	private List<PhoneDTO> phones = new ArrayList<>();
	private Boolean isActive;
	private Date lastLogin;
	private Date createdAt;
	private Date updatedAt;
}
