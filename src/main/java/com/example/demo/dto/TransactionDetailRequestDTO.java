package com.example.demo.dto;

public class TransactionDetailRequestDTO {
	
	private int id;
	
	private String wallet_Id;
	
	private double total_balance;
	
	private String message;

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

	public double getTotal_balance() {
		return total_balance;
	}

	public void setTotal_balance(double total_balance) {
		this.total_balance = total_balance;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	@Override
	public String toString() {
		return "TransactionDetailRequestDTO [id=" + id + ", wallet_Id=" + wallet_Id + ", total_balance=" + total_balance
				+ ", message=" + message + "]";
	}

	

	public TransactionDetailRequestDTO(int id, String wallet_Id, double total_balance, String message) {
		super();
		this.id = id;
		this.wallet_Id = wallet_Id;
		this.total_balance = total_balance;
		this.message = message;
	}

	public TransactionDetailRequestDTO() {
		super();
	}
	
	

}
