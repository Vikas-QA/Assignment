package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LoginRequestDTO {

	@NotNull(message = "email can't be null")
	@NotBlank(message = "email can't be empty")
	private String emailId;

	@NotNull(message = "password can't be null")
	@NotBlank(message = "password can't be empty")
	private String password;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRequestDTO [emailId=" + emailId + ", password=" + password + "]";
	}

	public LoginRequestDTO(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}

	public LoginRequestDTO() {
		super();
	}

}
