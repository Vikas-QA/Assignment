package com.example.demo.dto;
//
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotNull;
//
//
//
public class RegistrationResponseDTO {
	
	
	
	private String firstName;
	
	private String lastName;
	
	
	private String emailId;
	
	private String mobileNo;
	
	
	private RegistrationMessageDTO data;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public RegistrationMessageDTO getData() {
		return data;
	}
	public void setData(RegistrationMessageDTO data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "RegistrationResponseDTO [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", mobileNo=" + mobileNo + ", data=" + data + "]";
	}
	public RegistrationResponseDTO(String firstName, String lastName, String emailId, String mobileNo,
			RegistrationMessageDTO data) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.data = data;
	}
	public RegistrationResponseDTO() {
		super();
	}
	
	
	
	
	

}