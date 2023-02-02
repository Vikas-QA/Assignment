package com.example.demo.dto;

public class LoginResponseDTO {

	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "LoginResponseDTO [result=" + result + "]";
	}

	public LoginResponseDTO(String result) {
		super();
		this.result = result;
	}

	public LoginResponseDTO() {
		super();
	}

}
