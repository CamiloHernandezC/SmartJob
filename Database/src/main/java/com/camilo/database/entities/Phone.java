package com.camilo.database.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "phones")
public class Phone {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;
	@NotNull
	private String number;
	@NotNull
	@Column(name="city_code")
	private String cityCode;
	@NotNull
	@Column(name="country_code")
	private String countryCode;
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
}
