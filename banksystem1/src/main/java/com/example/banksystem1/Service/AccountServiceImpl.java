package com.example.banksystem1.Service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.banksystem1.Entity.Account;
import com.example.banksystem1.Repository.AccountRepository;
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        Account account_saved = accountRepository.save(account);
        return account_saved;
    }

    @Override
    public Account getAccountDetailsByAccountNumber(Long accountNumber) {
        Optional<Account> account = accountRepository.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account does not exist");
        }
        Account account_found = account.get();
        return account_found;
    }

    @Override
    public List<Account> getAllAccountDetails() {
        List<Account> listOfAccount = accountRepository.findAll();
        return listOfAccount;
    }

    @Override
    public Account depositMoney(Long accountNumber, Double amount) {
        Optional<Account> account = accountRepository.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account does not exist");
        }
        Account depositAccount = account.get();
        Double totalBalance = depositAccount.getAccount_balance()+amount;
        depositAccount.setAccount_balance(totalBalance);
        accountRepository.save(depositAccount);
        return depositAccount;
    }

    @Override
    public Account withdrawMoney(Long accountNumber, Double amount) {
        Optional<Account> account = accountRepository.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account does not exist");
        }
        Account withdrawAccount = account.get();
        Double accountBalance = withdrawAccount.getAccount_balance()-amount;
        withdrawAccount.setAccount_balance(accountBalance);
        accountRepository.save(withdrawAccount);
        return withdrawAccount;
    }

    @Override
    public void closeAccount(Long accountNumber) {
        Optional<Account> account = accountRepository.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account does not exist");
        }
        getAccountDetailsByAccountNumber(accountNumber);
        accountRepository.deleteById(accountNumber);
    }
    
}
