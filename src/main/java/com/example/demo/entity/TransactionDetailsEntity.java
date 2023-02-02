package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TransactionDetailsEntity")
public class TransactionDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "wallet_Id")
	private String wallet_Id;

	@Column(name = "old_Balance")
	private double old_Balance;

	@Column(name = "balance_Added")
	private double balance_Added;

	@Column(name = "balance_Deducted")
	private double balance_Deducted;

	@Column(name = "transaction_time")
	private LocalDateTime date_time;

	@Column(name = "transaction_Type")
	private String transaction_Type;

	@Column(name = "total_balance")
	private double total_balance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWallet_Id() {
		return wallet_Id;
	}

	public void setWallet_Id(String wallet_Id) {
		this.wallet_Id = wallet_Id;
	}

	public double getOld_Balance() {
		return old_Balance;
	}

	public void setOld_Balance(double old_Balance) {
		this.old_Balance = old_Balance;
	}

	public double getBalance_Added() {
		return balance_Added;
	}

	public void setBalance_Added(double balance_Added) {
		this.balance_Added = balance_Added;
	}

	public double getBalance_Deducted() {
		return balance_Deducted;
	}

	public void setBalance_Deducted(double balance_Deducted) {
		this.balance_Deducted = balance_Deducted;
	}

	public LocalDateTime getDate_time() {
		return date_time;
	}

	public void setDate_time(LocalDateTime date_time) {
		this.date_time = date_time;
	}

	public String getTransaction_Type() {
		return transaction_Type;
	}

	public void setTransaction_Type(String transaction_Type) {
		this.transaction_Type = transaction_Type;
	}

	public double getTotal_balance() {
		return total_balance;
	}

	public void setTotal_balance(double total_balance) {
		this.total_balance = total_balance;
	}

	@Override
	public String toString() {
		return "TransactionDetailsEntity [id=" + id + ", wallet_Id=" + wallet_Id + ", old_Balance=" + old_Balance
				+ ", balance_Added=" + balance_Added + ", balance_Deducted=" + balance_Deducted + ", date_time="
				+ date_time + ", transaction_Type=" + transaction_Type + ", total_balance=" + total_balance + "]";
	}

	public TransactionDetailsEntity(int id, String wallet_Id, double old_Balance, double balance_Added,
			double balance_Deducted, LocalDateTime date_time, String transaction_Type, double total_balance,
			String result) {
		super();
		this.id = id;
		this.wallet_Id = wallet_Id;
		this.old_Balance = old_Balance;
		this.balance_Added = balance_Added;
		this.balance_Deducted = balance_Deducted;
		this.date_time = date_time;
		this.transaction_Type = transaction_Type;
		this.total_balance = total_balance;

	}

	public TransactionDetailsEntity() {
		super();
	}

}
