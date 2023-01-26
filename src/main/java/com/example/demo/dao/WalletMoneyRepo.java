package com.example.demo.dao;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.WalletMoneyEntity;

import jakarta.transaction.Transactional;

public interface WalletMoneyRepo extends JpaRepository<WalletMoneyEntity, String> {

	@Query("SELECT count(wallet_Id) FROM WalletMoneyEntity r WHERE r.wallet_Id = ?1")
	int getWalletIdCount(String walletIdCount);

	@Query("SELECT wallet_Balance FROM WalletMoneyEntity r WHERE r.wallet_Id = ?1")
	double getBalanceByWalletId(String walletId);

	@Modifying
	@Transactional
	@Query("UPDATE WalletMoneyEntity r  SET r.wallet_Balance = ?2 , r.date_time=?3 WHERE r.wallet_Id = ?1")
	void updateWalletDetailsById(String walletId, double walletBalance, LocalDateTime date_time);

}
