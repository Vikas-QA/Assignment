package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.TransactionDetailsEntity;

public interface TransactionRepo extends JpaRepository<TransactionDetailsEntity, String> {

	@Query("SELECT r FROM TransactionDetailsEntity r WHERE r.wallet_Id = ?1")
	List<TransactionDetailsEntity> findByWalletId(String walletid);

	@Query("SELECT r FROM TransactionDetailsEntity r WHERE r.wallet_Id = ?1")
	List<TransactionDetailsEntity> findBywalletId(String walletid);

}
