package com.cts.onlinebanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.onlinebanking.model.CurrentAccount;
import com.cts.onlinebanking.model.SavingsAccount;
import com.cts.onlinebanking.model.TransferOthersAccount;
import com.cts.onlinebanking.repository.CurrentAccountRepository;
import com.cts.onlinebanking.repository.SavingsAccountRepository;
import com.cts.onlinebanking.repository.TransferRepository;

@Service
public class OtherAccountTransferService {

	@Autowired
	CurrentAccountRepository cRepository;

	@Autowired
	SavingsAccountRepository sRepository;

	@Autowired
	TransferRepository transferRepository;

	public int transferToOthers(TransferOthersAccount transferOthers, String userName) {
		transferOthers.setUserName(userName);
		int value = 0;
		if (transferOthers.getAcc1().equals("Savings Account")) {
			SavingsAccount sAccount = sRepository.findByUserName(userName);
			float balance = sAccount.getBalance() - transferOthers.getAmount();
			if (balance >= 0) {

				if (transferOthers.getAcc2().equals("Savings Account")) {
					SavingsAccount sAccount2 = sRepository.findByAccountNumber(transferOthers.getAccNumber());
					if (sAccount2 != null) {
						sAccount.setBalance(balance);
						transferOthers.setBalance(sAccount.getBalance());
						sAccount2.setBalance(sAccount2.getBalance() + transferOthers.getAmount());

						sRepository.save(sAccount2);
						value = 1;
					} else {
						value = 2;
					}
				} else {
					CurrentAccount cAccount2 = cRepository.findByAccountNumber(transferOthers.getAccNumber());
					if (cAccount2 != null) {
						sAccount.setBalance(balance);
						transferOthers.setBalance(sAccount.getBalance());
						cAccount2.setBalance(cAccount2.getBalance() + transferOthers.getAmount());
						cRepository.save(cAccount2);
						value = 1;
					} else {
						value = 2;
					}
				}

				transferRepository.save(transferOthers);
				sRepository.save(sAccount);
				return value;
			} else {
				return 0;
			}
		} else {
			CurrentAccount cAccount = cRepository.findByUserName(userName);
			float balance = cAccount.getBalance() - transferOthers.getAmount();
			if (balance >= 0) {

				if (transferOthers.getAcc2().equals("Savings Account")) {
					SavingsAccount sAccount2 = sRepository.findByAccountNumber(transferOthers.getAccNumber());
					if (sAccount2 != null) {
						cAccount.setBalance(balance);
						transferOthers.setBalance(cAccount.getBalance());
						sAccount2.setBalance(sAccount2.getBalance() + transferOthers.getAmount());
						sRepository.save(sAccount2);
						value = 1;
					} else {
						value = 2;
					}
				} else {
					CurrentAccount cAccount2 = cRepository.findByAccountNumber(transferOthers.getAccNumber());
					if (cAccount2 != null) {
						cAccount.setBalance(balance);
						transferOthers.setBalance(cAccount.getBalance());
						cAccount2.setBalance(cAccount2.getBalance() + transferOthers.getAmount());
						cRepository.save(cAccount2);
						value = 1;
					} else {
						value = 2;
					}
				}
				cRepository.save(cAccount);
				transferRepository.save(transferOthers);
				return value;
			} else {
				return 0;
			}
		}
	}

}
