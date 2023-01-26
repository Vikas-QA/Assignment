package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "WalletMoneyEntity")
public class WalletMoneyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "wallet_Id")
	private String wallet_Id;

	@Column(name = "Wallet_Balance")
	private double wallet_Balance;

	@Column(name = "Updated_at")
	private LocalDateTime date_time;

	public String getWalletId() {
		return wallet_Id;
	}

	public void setWalletId(String walletId) {
		this.wallet_Id = walletId;
	}

	public double getWalletBalance() {
		return wallet_Balance;
	}

	public void setWalletBalance(double walletBalance) {
		this.wallet_Balance = walletBalance;
	}

	public LocalDateTime getDate_time() {
		return date_time;
	}

	public void setDate_time(LocalDateTime date) {
		this.date_time = date;
	}

	@Override
	public String toString() {
		return "WalletMoney [walletId=" + wallet_Id + ", walletBalance=" + wallet_Balance + ", date_time=" + date_time
				+ "]";
	}

	public WalletMoneyEntity(String walletId, double walletBalance, LocalDateTime date_time) {
		super();
		this.wallet_Id = walletId;
		this.wallet_Balance = walletBalance;
		this.date_time = date_time;
	}

	public WalletMoneyEntity() {
		super();
	}

}
