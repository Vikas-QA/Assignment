package com.example.demo.dto;

public class RegistrationMessageDTO {

	String message;

	public RegistrationMessageDTO(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "RegistrationMessageDTO [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public RegistrationMessageDTO() {
		super();
	}
	
}
