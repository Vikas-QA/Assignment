package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.RegistrationEntity;

import jakarta.transaction.Transactional;

public interface WalletRepo extends JpaRepository<RegistrationEntity, String> {

	@Query("SELECT r FROM RegistrationEntity r WHERE r.emailId = ?1")
	public RegistrationEntity getByEmail(String email);

	@Query("SELECT count(emailId) FROM RegistrationEntity r WHERE r.emailId = ?1")
	public int getEmailCount(String email);

	@Query("SELECT count(walletId) FROM RegistrationEntity r WHERE r.walletId = ?1")
	int getWalletIdCount(String walletId);

	@Modifying
	@Transactional
	@Query("UPDATE RegistrationEntity r  SET r.firstName=?2, r.lastName=?3, r.mobileNo=?4 WHERE r.emailId = ?1")
	public void updateByEmailid(String email_Id, String first_Name, String last_Name, String mobile_no);

}
