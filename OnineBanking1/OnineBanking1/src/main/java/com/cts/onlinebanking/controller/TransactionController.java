package com.cts.onlinebanking.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import com.cts.onlinebanking.model.Deposit;
import com.cts.onlinebanking.model.TransferOthersAccount;
import com.cts.onlinebanking.model.Withdraw;
import com.cts.onlinebanking.service.AdminService;
import com.cts.onlinebanking.service.DepositService;
import com.cts.onlinebanking.service.UserService;
import com.cts.onlinebanking.service.WithdrawlService;

@Controller
public class TransactionController {

	DepositService dService;
	WithdrawlService wService;
	UserService ser;
	AdminService adminService;

	@Autowired
	public TransactionController(DepositService dService, WithdrawlService wService, UserService ser,
			AdminService adminService) {
		super();
		this.dService = dService;
		this.wService = wService;
		this.ser = ser;
		this.adminService = adminService;
	}

	@GetMapping("/deposit")
	public String showDeposit(@ModelAttribute("deposit") Deposit deposit, Principal principal) {
		return "deposit";
	}

	@PostMapping("/deposit")
	public String deposit(@ModelAttribute("deposit") Deposit deposit, Principal principal, Model model) {
		int isDeposited = dService.depositAmount(deposit, principal.getName());
		
		model.addAttribute("isDeposited", isDeposited);
		return "deposit";
	}

	@GetMapping("/withdrawl")
	public String showWithdrawl(@ModelAttribute("withdrawl") Withdraw withdraw) {

		return "withdrawl";
	}

	@PostMapping("/withdrawl")
	public String withDrawl(@ModelAttribute("withdrawl") Withdraw withdraw, Principal principal, Model model) {
		int isWithDraw = wService.withdrawlAmount(withdraw, principal.getName());
		model.addAttribute("isWithDraw", isWithDraw);
		return "withdrawl";
	}

	@ModelAttribute("accType")
	public List<String> populateAccountType() {
		List<String> list = new ArrayList<>();
		list.add("Savings Account");
		list.add("Current Account");
		return list;
	}

	@GetMapping("/withDrawHistory")
	public String showWithdrawl1(Withdraw withdraw, Deposit deposit, Principal principal, Model model) {
		List<Withdraw> list = ser.getTransferTransaction(principal.getName());
		Collections.reverse(list);
		model.addAttribute("details", list);
		return "withDrawHistory";
	}

	@GetMapping("/depositHistory")
	public String showWithdrawl2(Withdraw withdraw, Deposit deposit, Principal principal, Model model) {
		List<Deposit> list1 = adminService.getDepositTransaction(principal.getName());
		Collections.reverse(list1);
		model.addAttribute("details", list1);

		return "depositHistory";
	}

	@GetMapping("/transactionHistory")
	public String showWithdrawl3(Withdraw withdraw, Deposit deposit, Principal principal, Model model) {

		List<TransferOthersAccount> list3 = adminService.getTransferTransaction(principal.getName());
		Collections.reverse(list3);
		model.addAttribute("details", list3);
		return "transactionHistory";
	}
}
