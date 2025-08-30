package com.bankingApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankingApplication.entity.Account;
import com.bankingApplication.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService service;
	
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		
		Account createAccount = service.createAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
		
	}
	
	@GetMapping("/{id}")
	public Account getAccountByAccountNumber(@PathVariable Long id) {
		
		Account account = service.getAccountDetailsByAccountNumber(id);
		return account;
	}
	
	@GetMapping("/getallaccounts")
	public List<Account> getAllAccounts() {
		
		List<Account> allAccounts = service.getAllAccountsDetails();
		return allAccounts;
	}
	
	@PutMapping("/deposit/{accountNumber}/{amount}")
	public Account depositAmountInAccount(@PathVariable Long accountNumber, @PathVariable Double amount) {
		Account account = service.depositAmount(accountNumber, amount);
		return account;
	}
	
	@PutMapping("/withdraw/{accountNumber}/{amount}")
	public Account withdrawAmount(@PathVariable Long accountNumber, @PathVariable Double amount) {
		Account account = service.withdrawAmount(accountNumber, amount);
		return account;
	}
	
	@DeleteMapping("/delete/{accountNumber}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber) {
		
		service.deleteAccount(accountNumber);
		return ResponseEntity.ok("Account Closed!!");
	}

}
