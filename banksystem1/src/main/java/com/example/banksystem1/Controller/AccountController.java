package com.example.banksystem1.Controller;

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

import com.example.banksystem1.Entity.Account;
import com.example.banksystem1.Service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    //Create Account
    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        Account createAccount  = accountService.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
    }

    //get id by account
    @GetMapping("/{accountNumber}")
    public Account getAccountbyAccountNumber(@PathVariable Long accountNumber){
        Account account = accountService.getAccountDetailsByAccountNumber(accountNumber);
        return account;
    }

    //get all accounts
    @GetMapping("/getAllAccounts")
    public List<Account> getAllAccountDetails(){
        List<Account> allAccountDetails = accountService.getAllAccountDetails();
        return allAccountDetails;
    }

    //deposit by account number
    @PutMapping("/deposit/{accountNumber}/{amount}")
    public Account depositMoney(@PathVariable Long accountNumber,@PathVariable Double amount){
        Account account = accountService.depositMoney(accountNumber, amount);
        return account;
    }

    //withdraw by account number
    @PutMapping("/withdraw/{accountNumber}/{amount}")
    public Account withdrawMoney(@PathVariable Long accountNumber,@PathVariable Double amount){
        Account account = accountService.withdrawMoney(accountNumber, amount);
        return account;
    }

    //close by account number
    @DeleteMapping("/delete/{accountNumber}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber){
        accountService.closeAccount(accountNumber);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account number "+accountNumber+" is closed!!");
    }
    
}
