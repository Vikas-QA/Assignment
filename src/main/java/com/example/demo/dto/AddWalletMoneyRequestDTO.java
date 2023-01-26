package com.example.demo.dto;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record AddWalletMoneyRequestDTO(@NotNull @NotBlank(message="walled id is mandatory") String wallet_Id, 
		@DecimalMin(value="1.0", message="Balance is mandatory")  
       @Range(min = 100, max = 10000, message="Balance must be between 100-10000") double wallet_Balance, LocalDateTime date_time) {

	public void setDate_time(LocalDateTime date) {
		// TODO Auto-generated method stub
		
	}

}
