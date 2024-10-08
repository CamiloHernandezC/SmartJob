package com.camilo.usermicroservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmailTakenAdvice {
	
	@ResponseBody
	@ExceptionHandler(EmailTakenException.class)
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	ResponseEntity<String> emailTakenHandler(EmailTakenException ex) {
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).contentType(MediaType.APPLICATION_JSON).body(ex.getMessage());
	}
}
