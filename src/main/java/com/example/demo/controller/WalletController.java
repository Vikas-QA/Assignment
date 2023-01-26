package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.example.demo.service.WalletService;

import jakarta.validation.Valid;

@RestController
@EnableTransactionManagement
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	WalletService walletService;

	@PostMapping("/register")
	public RegistrationResponseDTO registerationDetails(@Valid @RequestBody RegistrationEntity register) {

		return walletService.registerationData(register);

	}

	@PostMapping("/updateById")
	public RegistrationResponseDTO updateBy_emailId(@RequestBody RegistrationRequestDTO registrationRequestDTO) {

		return walletService.updateByEmailId(registrationRequestDTO);
	}

	@PostMapping("/addBalance")
	public AddWalletMoneyResponseDTO add_balance(
			@Valid @RequestBody AddWalletMoneyRequestDTO addwalletbalancerequestdto) {

		return walletService.add_wallet_balance(addwalletbalancerequestdto);

	}

	@PostMapping("/transferbalance")
	private TransferBalanceResponseDTO transferBalance(@Valid @RequestBody TransferBalanceRequestDTO transferbalance) {

		return walletService.transfer_balance(transferbalance);

	}

	@GetMapping("/getTrasactionDetails/{walletId}")
	public List<TransactionDetailsEntity> transactionDetails(@Valid @PathVariable String walletId) {

		List<TransactionDetailsEntity> transactionDetailsEntity = walletService.getTransactionDetails(walletId);

		return transactionDetailsEntity;

	}

	@PostMapping("/login")
	public LoginResponseDTO loginVerification(@Valid @RequestBody LoginRequestDTO login) {

		return walletService.loginVerification(login);

	}

}
