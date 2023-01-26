package com.example.demo.dto;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TransferBalanceRequestDTO {

	@NotNull(message = "sender_WalletId can't be null")
	@NotBlank(message = "sender_WalletId can't be empty")
	private String sender_WalletId;

	@NotNull(message = "receiver_WalletId can't be null")
	@NotBlank(message = "receiver_WalletId can't be empty")
	private String receiver_WalletId;

	@Range(min = 100, max = 10000, message = "amount tranfer limit is 100-10000")
	@DecimalMin(value = "1.0", message = "invalid amount type")
	private double amount_Transfer;

	private LocalDateTime date_time;

	public String getSender_WalletId() {
		return sender_WalletId;
	}

	public void setSender_WalletId(String sender_WalletId) {
		this.sender_WalletId = sender_WalletId;
	}

	public String getReceiver_WalletId() {
		return receiver_WalletId;
	}

	public void setReceiver_WalletId(String receiver_WalletId) {
		this.receiver_WalletId = receiver_WalletId;
	}

	public double getAmount_Transfer() {
		return amount_Transfer;
	}

	public void setAmount_Transfer(double amount_Transfer) {
		this.amount_Transfer = amount_Transfer;
	}

	public LocalDateTime getDate_time() {
		return date_time;
	}

	public void setDate_time(LocalDateTime date_time) {
		this.date_time = date_time;
	}

	@Override
	public String toString() {
		return "TransferBalanceRequest [sender_WalletId=" + sender_WalletId + ", receiver_WalletId=" + receiver_WalletId
				+ ", amount_Transfer=" + amount_Transfer + ", date_time=" + date_time + "]";
	}

	public TransferBalanceRequestDTO(String sender_WalletId, String receiver_WalletId, double amount_Transfer,
			LocalDateTime date_time) {
		super();
		this.sender_WalletId = sender_WalletId;
		this.receiver_WalletId = receiver_WalletId;
		this.amount_Transfer = amount_Transfer;
		this.date_time = date_time;
	}

	public TransferBalanceRequestDTO() {
		super();
	}

}
