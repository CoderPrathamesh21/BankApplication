package com.bankingApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingApplication.entity.Account;
import com.bankingApplication.repository.AccountRepo;

@Service
public class AcoountServiceImpl implements AccountService {

	@Autowired
	private AccountRepo repo;
	
	@Override
	public Account createAccount(Account account) {
		
		Account account_saved = repo.save(account);
		return account_saved;
	}

	@Override
	public Account getAccountDetailsByAccountNumber(Long accountNumber) {
	
		Optional<Account> account = repo.findById(accountNumber);
		
		if (account.isEmpty()) {
			throw new RuntimeException("Account does not exists.");
		}
		
		Account account_found = account.get();
		return account_found;
	}

	@Override
	public List<Account> getAllAccountsDetails() {
		List<Account> listOfAccounts = repo.findAll();
		return listOfAccounts;
	}

	@Override
	public Account depositAmount(Long accountNumber, Double amount) {
		Optional<Account> account = repo.findById(accountNumber);
		
		if (account.isEmpty()) {
			throw new RuntimeException("Account does not exists.");
		}
		
		Account existingAccount = account.get();
		Double totalBalance = existingAccount.getAccount_balance() + amount;
		existingAccount.setAccount_balance(totalBalance);
		repo.save(existingAccount);
		return existingAccount;
	}

	@Override
	public Account withdrawAmount(Long accountNumber, Double amount) {
		
		Optional<Account> account = repo.findById(accountNumber);
		
		if (account.isEmpty()) {
			throw new RuntimeException("Account does not exists.");
		}
		
		Account existingAccount = account.get();
		Double accountBalance = existingAccount.getAccount_balance() - amount;
		existingAccount.setAccount_balance(accountBalance);
		repo.save(existingAccount);
		return existingAccount;
	}

	@Override
	public void deleteAccount(Long accountNumber) {
		getAccountDetailsByAccountNumber(accountNumber);
		repo.deleteById(accountNumber);
		
	}

}
