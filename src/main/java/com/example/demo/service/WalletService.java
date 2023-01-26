package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AddWalletMoneyRequestDTO;
import com.example.demo.dto.AddWalletMoneyResponseDTO;
import com.example.demo.dto.LoginRequestDTO;
import com.example.demo.dto.LoginResponseDTO;
import com.example.demo.dto.RegistrationRequestDTO;
import com.example.demo.dto.RegistrationResponseDTO;
import com.example.demo.dto.TransferBalanceRequestDTO;
import com.example.demo.dto.TransferBalanceResponseDTO;
import com.example.demo.entity.RegistrationEntity;
import com.example.demo.entity.TransactionDetailsEntity;
import com.example.demo.entity.WalletMoneyEntity;

public interface WalletService {

	RegistrationResponseDTO registerationData(RegistrationEntity register);

	RegistrationEntity getByEmail(String email);

	List<TransactionDetailsEntity> getTransactionDetails(String walletId);

	double getBalanceByWalletId(String walletId);

	void updateWalletDetailById(WalletMoneyEntity addbalance);

	LoginResponseDTO loginVerification(LoginRequestDTO login);

	TransferBalanceResponseDTO transfer_balance(TransferBalanceRequestDTO transferbalance);

	AddWalletMoneyResponseDTO add_wallet_balance(AddWalletMoneyRequestDTO addwalletbalancerequestdto);

	RegistrationResponseDTO updateByEmailId(RegistrationRequestDTO registrationRequestDTO);

}
