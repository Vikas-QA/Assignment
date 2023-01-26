package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity

@Table(name = "RegistrationEntity")
public class RegistrationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@NotNull(message = "First name can't be null")
	@NotBlank(message = "First name can't be empty")
	@Column(name = "firstName")
	private String firstName;

	@NotNull(message = "Last name can't be null")
	@NotBlank(message = "Last name can't be empty")
	@Column(name = "lastName")
	private String lastName;

	@Email(regexp = "[A-Za-z0-9._]+@[a-z]+\\.[a-z]{2,3}", message = "Invalid email address")
	@NotNull(message = "Email can't be null")
	@NotBlank(message = "Email can't be empty")
	@Column(name = "emailId")
	private String emailId;

	@Column(name = "mobileNo")
	private String mobileNo;

	@Pattern(regexp = "^(?=.*\\d)(?=.*)(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}$", message = "Value must contain 1 uppercase, 1 number, and 1 special character")
	@NotNull(message = "Password can't be null")
	@NotBlank(message = "Password can't be empty")
	@Column(name = "password")
	private String password;

	private String walletId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWalletId() {
		return walletId;
	}

	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}

	@Override
	public String toString() {
		return "RegistrationEntity [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", password=" + password + ", walletId="
				+ walletId + "]";
	}

	public RegistrationEntity(int userId, String firstName, String lastName, String emailId, String mobileNo,
			String password, String walletId) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.password = password;
		this.walletId = walletId;
	}

	public RegistrationEntity() {
		super();
	}

}
