package com.camilo.usermicroservice.exceptions;

public class EmailTakenException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmailTakenException() {
	    super("El correo ya registrado");
	}
}
