package com.squidco.demo.service;

import java.util.List;

import com.squidco.demo.entity.Account;
import com.squidco.demo.repository.AccountRepo;

public class AccountServiceImpl implements AccountService {

    private AccountRepo repo;

    public AccountServiceImpl(AccountRepo accountRepo) {
        repo = accountRepo;
    }

    @Override
    public List<Account> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Account account) {
        // TODO Auto-generated method stub
        
        repo.save(account);
    }
    
}
