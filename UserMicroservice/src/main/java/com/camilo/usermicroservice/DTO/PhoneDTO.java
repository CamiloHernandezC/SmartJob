package com.camilo.usermicroservice.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor @AllArgsConstructor
public class PhoneDTO {
	
	private Long id;
	private String number;
	@JsonProperty("city_code")
	private String cityCode;
	@JsonProperty("country_code")
	private String countryCode;
}
