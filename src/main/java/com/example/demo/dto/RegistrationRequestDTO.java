package com.example.demo.dto;

public class RegistrationRequestDTO {
	
	private String first_Name;
	
	private String last_Name;
	
	private String email_Id;
	
	private String mobile_no;

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	

	public String getEmail_Id() {
		return email_Id;
	}

	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}

	

	@Override
	public String toString() {
		return "RegistrationRequestDTO [first_Name=" + first_Name + ", last_Name=" + last_Name + ", email_Id="
				+ email_Id + ", mobile_no=" + mobile_no + "]";
	}

	public RegistrationRequestDTO(String first_Name, String last_Name, String email_Id, String mobile_no) {
		super();
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.mobile_no = mobile_no;
		this.email_Id = email_Id;
	}

	public RegistrationRequestDTO() {
		super();
	}

	
}
