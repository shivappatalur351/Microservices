package com.cts.onlinebanking.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.onlinebanking.model.CurrentAccount;
import com.cts.onlinebanking.model.Deposit;
import com.cts.onlinebanking.model.SavingsAccount;
import com.cts.onlinebanking.model.SelfTransfer;
import com.cts.onlinebanking.model.TransferOthersAccount;
import com.cts.onlinebanking.model.UserDetailsList;
import com.cts.onlinebanking.model.UserRegistration;
import com.cts.onlinebanking.model.Withdraw;
import com.cts.onlinebanking.repository.CurrentAccountRepository;
import com.cts.onlinebanking.repository.DepositRepository;
import com.cts.onlinebanking.repository.SavingsAccountRepository;
import com.cts.onlinebanking.repository.SelfTransferRepository;
import com.cts.onlinebanking.repository.TransferRepository;
import com.cts.onlinebanking.repository.UserDetailsRepository;
import com.cts.onlinebanking.repository.UserRegistrationRepository;
import com.cts.onlinebanking.repository.UserRepository;
import com.cts.onlinebanking.repository.WithdrawRepository;

@Service
@Transactional
public class AdminService {

	CurrentAccountRepository cRepository;
	SavingsAccountRepository sRepository;
	UserDetailsRepository detailsRepository;
	UserRegistrationRepository uRepository;
	DepositRepository depositRepository;
	WithdrawRepository withdrawRepository;
	TransferRepository transferRepository;
	SelfTransferRepository selfRepository;
	UserRepository userRepository;
	SavingsAccountRepository savingsAccountRepository;
	CurrentAccountRepository currentAccountRepository;

	@Autowired
	public AdminService(CurrentAccountRepository cRepository, SavingsAccountRepository sRepository,
			UserDetailsRepository detailsRepository, UserRegistrationRepository uRepository,
			DepositRepository depositRepository, WithdrawRepository withdrawRepository,
			TransferRepository transferRepository, SelfTransferRepository selfRepository, UserRepository userRepository,
			SavingsAccountRepository savingsAccountRepository, CurrentAccountRepository currentAccountRepository) {
		super();
		this.cRepository = cRepository;
		this.sRepository = sRepository;
		this.detailsRepository = detailsRepository;
		this.uRepository = uRepository;
		this.depositRepository = depositRepository;
		this.withdrawRepository = withdrawRepository;
		this.transferRepository = transferRepository;
		this.selfRepository = selfRepository;
		this.userRepository = userRepository;
		this.savingsAccountRepository = savingsAccountRepository;
		this.currentAccountRepository = currentAccountRepository;
	}

	public List<SavingsAccount> getSavingDetail() {
		List<SavingsAccount> sAccount = sRepository.findAll();
		return sAccount;
	}

	public List<CurrentAccount> getCurrentDetail() {
		List<CurrentAccount> cAccount = cRepository.findAll();
		return cAccount;
	}

	public void saveUserDetails(List<SavingsAccount> sAccount, List<CurrentAccount> cAccount) {
		detailsRepository.deleteAll();
		for (SavingsAccount s : sAccount) {
			CurrentAccount c = cRepository.findByUserName(s.getUserName());
			UserRegistration userRegistration = uRepository.findByUserName(s.getUserName());
			UserDetailsList user = new UserDetailsList();
			user.setUserName(s.getUserName());
			user.setName(userRegistration.getName());
			user.setSavingsNumber(s.getAccountNumber());
			user.setSavingsBalance(s.getBalance());
			user.setCurrentNumber(c.getAccountNumber());
			user.setCurrentBalance(c.getBalance());
			detailsRepository.save(user);
			System.out.println(user);
		}

	}

	public List<UserDetailsList> getUserDetails() {
		List<UserDetailsList> list = detailsRepository.findAll();
		return list;
	}

	public List<Deposit> getDepositTransaction() {
		List<Deposit> list = depositRepository.findAll();
		for (Deposit d : list) {
			System.out.println(d.getBalance());
		}
		return list;
	}

	public List<Withdraw> getWithdrawTransaction() {
		return withdrawRepository.findAll();
	}

	public List<TransferOthersAccount> getTransferTransaction() {
		return transferRepository.findAll();
	}

	public List<SelfTransfer> getSelfTransaction() {
		return selfRepository.findAll();
	}

	public void removeUser(String userName) {
		uRepository.deleteByUserName(userName);
		userRepository.deleteByUserName(userName);
		sRepository.deleteByUserName(userName);
		cRepository.deleteByUserName(userName);
		savingsAccountRepository.deleteByUserName(userName);
		currentAccountRepository.deleteByUserName(userName);

	}

	String name;

	public List<Deposit> getDepositTransaction(String name) {
		this.name = name;
		List<Deposit> list = depositRepository.findAll();
		ArrayList<Deposit> lis = new ArrayList<Deposit>();
		for (Deposit d : list) {
			if (d.getUserName().equals(name)) {
				System.out.println(d + "" + name);
				lis.add(d);
			}
		}
		System.out.println(list);
		System.out.println(lis);
		return lis;
	}

	public List<TransferOthersAccount> getTransferTransaction(String name) {
		List<TransferOthersAccount> list = transferRepository.findAll();
		ArrayList<TransferOthersAccount> lis = new ArrayList<TransferOthersAccount>();
		for (TransferOthersAccount d : list) {
			if (d.getUserName().equals(name)) {
				System.out.println(d + "" + name);
				lis.add(d);
			}
		}
		System.out.println(list);
		System.out.println(lis);
		return lis;
	}
}
