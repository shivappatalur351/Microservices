package com.cts.onlinebanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.onlinebanking.model.CurrentAccount;
import com.cts.onlinebanking.model.Deposit;
import com.cts.onlinebanking.model.SavingsAccount;
import com.cts.onlinebanking.model.Withdraw;
import com.cts.onlinebanking.repository.CurrentAccountRepository;
import com.cts.onlinebanking.repository.SavingsAccountRepository;
import com.cts.onlinebanking.repository.WithdrawRepository;

@Service
public class WithdrawlService {

	@Autowired
	CurrentAccountRepository cRepository;

	@Autowired
	SavingsAccountRepository sRepository;

	@Autowired
	WithdrawRepository withdrawRepository;

	public int withdrawlAmount(Withdraw withdrawl, String userName) {
		withdrawl.setUserName(userName);
		String accountType = withdrawl.getAccType();
		if (accountType.equalsIgnoreCase("Savings Account")) {
			SavingsAccount sAccount = sRepository.findByUserName(userName);
			float tot = sAccount.getBalance() - withdrawl.getWithdrawlAmt();
			if (tot >= 0) {
				sAccount.setBalance(tot);
				withdrawl.setBalance(tot);
				withdrawRepository.save(withdrawl);
				sRepository.save(sAccount);
				return 1;
			} else {
				return 0;
			}
		} else {
			CurrentAccount cAccount = cRepository.findByUserName(userName);
			float tot = cAccount.getBalance() - withdrawl.getWithdrawlAmt();
			if (tot >= 0) {
				cAccount.setBalance(tot);
				withdrawl.setBalance(tot);
				withdrawRepository.save(withdrawl);
				cRepository.save(cAccount);
				return 1;
			} else {
				return 0;
			}
		}

	}

}
