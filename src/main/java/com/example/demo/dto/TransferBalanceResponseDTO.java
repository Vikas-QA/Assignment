package com.example.demo.dto;

public class TransferBalanceResponseDTO {

	private String message;

	private double transfered_amount;

	private String sending_from;

	private String sending_to;

	public String getmessage() {
		return message;
	}

	public void setmessage(String message) {
		this.message = message;
	}

	public double getTransfered_amount() {
		return transfered_amount;
	}

	public void setTransfered_amount(double transfered_amount) {
		this.transfered_amount = transfered_amount;
	}

	public String getSending_from() {
		return sending_from;
	}

	public void setSending_from(String sending_from) {
		this.sending_from = sending_from;
	}

	public String getSending_to() {
		return sending_to;
	}

	public void setSending_to(String sending_to) {
		this.sending_to = sending_to;
	}

	@Override
	public String toString() {
		return "TransferBalanceResponse [message=" + message + ", transfered_amount=" + transfered_amount
				+ ", sending_from=" + sending_from + ", sending_to=" + sending_to + "]";
	}

	public TransferBalanceResponseDTO(String message, double transfered_amount, String sending_from,
			String sending_to) {
		super();
		this.message = message;
		this.transfered_amount = transfered_amount;
		this.sending_from = sending_from;
		this.sending_to = sending_to;
	}

	public TransferBalanceResponseDTO() {
		super();
	}

}
