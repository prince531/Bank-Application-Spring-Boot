package com.example.banksystem1.Service;

import java.util.List;

import com.example.banksystem1.Entity.Account;

public interface AccountService {
    public Account createAccount(Account account);
    public Account getAccountDetailsByAccountNumber(Long accountNumber);
    public List<Account> getAllAccountDetails();
    public Account depositMoney(Long accountNumber, Double amount);
    public Account withdrawMoney(Long accountNumber, Double amount);
    public void closeAccount(Long accountNumber); 
}
