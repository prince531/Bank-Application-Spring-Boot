package com.example.banksystem1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.banksystem1.Entity.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    
}
