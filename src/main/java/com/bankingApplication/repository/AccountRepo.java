package com.bankingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankingApplication.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Long>{

}
