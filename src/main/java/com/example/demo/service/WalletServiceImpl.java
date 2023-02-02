package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TransactionRepo;
import com.example.demo.dao.WalletMoneyRepo;
import com.example.demo.dao.WalletRepo;
import com.example.demo.dto.AddWalletMoneyRequestDTO;
import com.example.demo.dto.AddWalletMoneyResponseDTO;
import com.example.demo.dto.LoginRequestDTO;
import com.example.demo.dto.LoginResponseDTO;
import com.example.demo.dto.RegistrationMessageDTO;
import com.example.demo.dto.RegistrationRequestDTO;
import com.example.demo.dto.RegistrationResponseDTO;
import com.example.demo.dto.TransferBalanceRequestDTO;
import com.example.demo.dto.TransferBalanceResponseDTO;
import com.example.demo.entity.RegistrationEntity;
import com.example.demo.entity.TransactionDetailsEntity;
import com.example.demo.entity.WalletMoneyEntity;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	WalletRepo walletRepo;

	@Autowired
	WalletMoneyRepo walletMoneyRepo;

	@Autowired
	TransactionRepo transactionRepo;

	@Override
	public RegistrationResponseDTO registerationData(RegistrationEntity register) {
		String user_emailId = register.getEmailId();
		boolean emailId_count = getEmailFlag(user_emailId);
		if (emailId_count == false) {

			String walletId = user_emailId;
			register.setWalletId(walletId);
			walletRepo.save(register);

			return new RegistrationResponseDTO(register.getFirstName(), register.getLastName(), register.getEmailId(),
					register.getMobileNo(), new RegistrationMessageDTO("success"));
		} else {

			return new RegistrationResponseDTO(register.getFirstName(), register.getLastName(), register.getEmailId(),
					register.getMobileNo(), new RegistrationMessageDTO("Email id already present"));

		}

	}

	@Override
	public RegistrationEntity getByEmail(String email) {

		return walletRepo.getByEmail(email);
	}

	@Override
	public List<TransactionDetailsEntity> getTransactionDetails(String walletId) {

		return transactionRepo.findBywalletId(walletId);
	}

	@Override
	public double getBalanceByWalletId(String walletId) {

		return walletMoneyRepo.getBalanceByWalletId(walletId);
	}

	@Override
	public void updateWalletDetailById(WalletMoneyEntity addbalance) {
		walletMoneyRepo.updateWalletDetailsById(addbalance.getWalletId(), addbalance.getWalletBalance(),
				addbalance.getDate_time());

	}

	@Override
	public TransferBalanceResponseDTO transfer_balance(TransferBalanceRequestDTO transferbalance) {

		if (transferbalance.getSender_WalletId().trim().equals(transferbalance.getReceiver_WalletId().trim())) {
			return new TransferBalanceResponseDTO("Wallet id can't be same", transferbalance.getAmount_Transfer(),
					transferbalance.getSender_WalletId(), transferbalance.getReceiver_WalletId());
		} else {

			String sender_walletId = transferbalance.getSender_WalletId().trim();
			String receiver_walletId = transferbalance.getReceiver_WalletId().trim();

			boolean s_registered_walletId_flag = registered_walletId_flag(sender_walletId);
			boolean r_registered_walletId_flag = registered_walletId_flag(receiver_walletId);
			if (s_registered_walletId_flag == false && r_registered_walletId_flag == false) {

				return new TransferBalanceResponseDTO("Both wallet id are incorrect.",
						transferbalance.getAmount_Transfer(), transferbalance.getSender_WalletId(),
						transferbalance.getReceiver_WalletId());
			}

			else if (s_registered_walletId_flag == false) {
				return new TransferBalanceResponseDTO("Incorrect sender wallet id.",
						transferbalance.getAmount_Transfer(), transferbalance.getSender_WalletId(),
						transferbalance.getReceiver_WalletId());

			} else if (r_registered_walletId_flag == false) {
				return new TransferBalanceResponseDTO("Incorrect receiver wallet id.",
						transferbalance.getAmount_Transfer(), transferbalance.getSender_WalletId(),
						transferbalance.getReceiver_WalletId());
			}

			else {
				double sender_balance = getBalanceByWalletId(transferbalance.getSender_WalletId().trim());
				double amount_transfer = transferbalance.getAmount_Transfer();
				if (sender_balance >= amount_transfer) {
					update_wallet_trasaction(transferbalance);
					return new TransferBalanceResponseDTO("Amount transfered successfully.",
							transferbalance.getAmount_Transfer(), transferbalance.getSender_WalletId(),
							transferbalance.getReceiver_WalletId());
				} else {
					return new TransferBalanceResponseDTO("Low Balance can't send money",
							transferbalance.getAmount_Transfer(), transferbalance.getSender_WalletId(),
							transferbalance.getReceiver_WalletId());
				}

			}

		}

	}

	private void update_wallet_trasaction(TransferBalanceRequestDTO transferbalance) {
		LocalDateTime date = LocalDateTime.now();
		transferbalance.setDate_time(date);

		WalletMoneyEntity walletMoneyEntity = new WalletMoneyEntity();
		double sender_balance = getBalanceByWalletId(transferbalance.getSender_WalletId());

		double debited_balance = transferbalance.getAmount_Transfer();

		double total_senderBalance = sender_balance - debited_balance;

		walletMoneyEntity.setWalletId(transferbalance.getSender_WalletId());
		walletMoneyEntity.setWalletBalance(total_senderBalance);

		walletMoneyRepo.updateWalletDetailsById(walletMoneyEntity.getWalletId(), walletMoneyEntity.getWalletBalance(),
				walletMoneyEntity.getDate_time());

		double receiver_balance = getBalanceByWalletId(transferbalance.getReceiver_WalletId());

		double credited_balance = transferbalance.getAmount_Transfer();

		double total_receiverBalance = receiver_balance + credited_balance;

		walletMoneyEntity.setWalletId(transferbalance.getReceiver_WalletId());
		walletMoneyEntity.setWalletBalance(total_receiverBalance);

		walletMoneyRepo.updateWalletDetailsById(walletMoneyEntity.getWalletId(), walletMoneyEntity.getWalletBalance(),
				walletMoneyEntity.getDate_time());

		update_transaction_detail(transferbalance, sender_balance, debited_balance, total_senderBalance,
				receiver_balance, credited_balance, total_receiverBalance);

	}

	private void update_transaction_detail(TransferBalanceRequestDTO transferbalance, double sender_balance,
			double debited_balance, double total_senderBalance, double receiver_balance, double credited_balance,
			double total_receiverBalance

	) {

		TransactionDetailsEntity transfer_balance = new TransactionDetailsEntity();
		transfer_balance.setBalance_Deducted(debited_balance);
		transfer_balance.setOld_Balance(sender_balance);
		transfer_balance.setTotal_balance(total_senderBalance);
		transfer_balance.setTransaction_Type("Debit");
		transfer_balance.setWallet_Id(transferbalance.getSender_WalletId());
		transfer_balance.setDate_time(transferbalance.getDate_time());
		transactionRepo.save(transfer_balance);

		TransactionDetailsEntity received_balance = new TransactionDetailsEntity();
		received_balance.setBalance_Added(credited_balance);
		received_balance.setOld_Balance(receiver_balance);
		received_balance.setTotal_balance(total_receiverBalance);
		received_balance.setWallet_Id(transferbalance.getReceiver_WalletId());
		received_balance.setTransaction_Type("Credit");
		received_balance.setDate_time(transferbalance.getDate_time());
		transactionRepo.save(received_balance);

	}

	@Override

	public LoginResponseDTO loginVerification(LoginRequestDTO login) {
		String email = login.getEmailId();
		String password = login.getPassword();

		boolean emailFlag = getEmailFlag(email);

		if (emailFlag == true) {
			RegistrationEntity registrationEntity = getByEmail(email);

			if (email.equals(registrationEntity.getEmailId()) && password.equals(registrationEntity.getPassword())) {
				return new LoginResponseDTO("Successfully logged in!");
			} else {
				return new LoginResponseDTO("Incorrect password, please enter correct password.");
			}
		} else {
			return new LoginResponseDTO("Email id not available!!");
		}

	}

	private boolean getEmailFlag(String email) {

		int emailCount = walletRepo.getEmailCount(email);
		if (emailCount == 0) {
			return false;
		} else if (emailCount == 1) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public AddWalletMoneyResponseDTO add_wallet_balance(AddWalletMoneyRequestDTO addwalletbalancerequestdto) {
		LocalDateTime date = LocalDateTime.now();
		addwalletbalancerequestdto.setDate_time(date);
		String walletId = addwalletbalancerequestdto.wallet_Id();

		double transactionAmount = addwalletbalancerequestdto.wallet_Balance();

		WalletMoneyEntity walletmoneyentity = new WalletMoneyEntity();
		walletmoneyentity.setWalletBalance(transactionAmount);
		walletmoneyentity.setWalletId(addwalletbalancerequestdto.wallet_Id());
		walletmoneyentity.setDate_time(date);

		TransactionDetailsEntity transactiondetailsentity = new TransactionDetailsEntity();
		transactiondetailsentity.setTransaction_Type("Credit");
		boolean wallet_Count = count_WalletId(walletId);

		boolean registered_walletId_flag = registered_walletId_flag(walletId);

		if (registered_walletId_flag) {

			if (wallet_Count) {

				walletMoneyRepo.save(walletmoneyentity);

				// first time by default balance is zero.
				transactiondetailsentity.setOld_Balance(0.0);

			} else {

				double oldBalance = getBalanceByWalletId(addwalletbalancerequestdto.wallet_Id());

				transactiondetailsentity.setOld_Balance(oldBalance);
				double newBalance = addwalletbalancerequestdto.wallet_Balance();
				double updatedBalance = oldBalance + newBalance;
				walletmoneyentity.setWalletBalance(updatedBalance);
				walletmoneyentity.setDate_time(date);
				updateWalletDetailById(walletmoneyentity);

			}

			transactiondetailsentity.setBalance_Added(transactionAmount);
			transactiondetailsentity.setDate_time(walletmoneyentity.getDate_time());
			transactiondetailsentity.setWallet_Id(walletmoneyentity.getWalletId());
			transactiondetailsentity.setTotal_balance(walletmoneyentity.getWalletBalance());
			transactiondetailsentity.setDate_time(walletmoneyentity.getDate_time());
			transactionRepo.save(transactiondetailsentity);

			return new AddWalletMoneyResponseDTO("Balance successfully added.");

		} else {

			return new AddWalletMoneyResponseDTO("Wallet id not present.");

		}

	}

	private boolean registered_walletId_flag(String walletId) {
		int walletId_Count = walletRepo.getWalletIdCount(walletId);
		if (walletId_Count == 0) {
			return false;
		} else {
			return true;
		}

	}

	private boolean count_WalletId(String walletId) {
		int wallet_IdCount = walletMoneyRepo.getWalletIdCount(walletId);
		if (wallet_IdCount == 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public RegistrationResponseDTO updateByEmailId(RegistrationRequestDTO registrationRequestDTO) {

		walletRepo.updateByEmailid(registrationRequestDTO.getEmail_Id(), registrationRequestDTO.getFirst_Name(),
				registrationRequestDTO.getLast_Name(), registrationRequestDTO.getMobile_no());

		RegistrationResponseDTO registrationResponseDTO = new RegistrationResponseDTO();
		registrationResponseDTO.setEmailId(registrationRequestDTO.getEmail_Id());
		registrationResponseDTO.setFirstName(registrationRequestDTO.getFirst_Name());
		registrationResponseDTO.setLastName(registrationRequestDTO.getLast_Name());
		registrationResponseDTO.setMobileNo(registrationRequestDTO.getMobile_no());
		registrationResponseDTO.setData(new RegistrationMessageDTO("success"));

		return registrationResponseDTO;
	}

}
