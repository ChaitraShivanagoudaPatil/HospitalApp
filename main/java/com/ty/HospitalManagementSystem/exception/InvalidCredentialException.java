package com.ty.HospitalManagementSystem.exception;

public class InvalidCredentialException extends RuntimeException{
	private String message="Invalid Credential";

	public String getMessage() {
		return message;
	}
	public InvalidCredentialException(String message) {
		super();
		this.message = message;
	}

	public InvalidCredentialException() {
		super();
	}
}
