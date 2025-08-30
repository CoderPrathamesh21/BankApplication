package com.bankingApplication.service;

import java.util.List;

import com.bankingApplication.entity.Account;

public interface AccountService {
	
	public Account createAccount(Account account);
	
	public Account getAccountDetailsByAccountNumber(Long accountNumber);
	
	public List<Account> getAllAccountsDetails();
	
	public Account depositAmount(Long accountNumber, Double amount);
	
	public Account withdrawAmount(Long accountNumber, Double amount);
	
	public void deleteAccount(Long accountNumber);
	

}
