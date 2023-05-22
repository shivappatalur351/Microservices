package com.cts.onlinebanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.onlinebanking.model.CurrentAccount;
import com.cts.onlinebanking.model.SavingsAccount;
import com.cts.onlinebanking.model.SelfTransfer;
import com.cts.onlinebanking.repository.CurrentAccountRepository;
import com.cts.onlinebanking.repository.SavingsAccountRepository;
import com.cts.onlinebanking.repository.SelfTransferRepository;

@Service
public class SelfTransferService {

	@Autowired
	CurrentAccountRepository cRepository;

	@Autowired
	SavingsAccountRepository sRepository;

	@Autowired
	SelfTransferRepository sTRepository;

	public int selfTransfer(SelfTransfer transfer, String userName) {

		if (transfer.getAcc1().equals("Current Account")) {
			transfer.setUserName(userName);
			transfer.setAcc2("Savings Account");
			CurrentAccount cAccount = cRepository.findByUserName(userName);
			float balance = cAccount.getBalance() - transfer.getAmount();
			System.out.println(balance);
			if (balance >= 0) {
				cAccount.setBalance(balance);
				cRepository.save(cAccount);
				SavingsAccount sAccount = sRepository.findByUserName(userName);
				sAccount.setBalance(sAccount.getBalance() + transfer.getAmount());
				sTRepository.save(transfer);
				sRepository.save(sAccount);
				return 1;
			} else {
				return 0;
			}
		} else {
			transfer.setUserName(userName);
			transfer.setAcc2("Current Account");
			SavingsAccount sAccount = sRepository.findByUserName(userName);
			float balance = sAccount.getBalance() - transfer.getAmount();
			sAccount.setBalance(balance);
			if (balance >= 0) {
				sRepository.save(sAccount);
				CurrentAccount cAccount = cRepository.findByUserName(userName);
				cAccount.setBalance(cAccount.getBalance() + transfer.getAmount());
				sTRepository.save(transfer);
				cRepository.save(cAccount);
				return 1;
			} else {
				return 0;
			}

		}
	}

}
