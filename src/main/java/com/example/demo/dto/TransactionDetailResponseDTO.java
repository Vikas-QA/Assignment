package com.example.demo.dto;

public class TransactionDetailResponseDTO {

	private String wallet_Id;

	private String result;

	public String getWallet_Id() {
		return wallet_Id;
	}

	public void setWallet_Id(String wallet_Id) {
		this.wallet_Id = wallet_Id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "TransactionDetailResponseDTO [wallet_Id=" + wallet_Id + ", result=" + result + "]";
	}

	public TransactionDetailResponseDTO(String wallet_Id, String result) {
		super();
		this.wallet_Id = wallet_Id;
		this.result = result;
	}

	public TransactionDetailResponseDTO() {
		super();
	}

}
