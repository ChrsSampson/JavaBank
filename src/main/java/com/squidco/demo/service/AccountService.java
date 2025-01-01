package com.squidco.demo.service;

import java.util.List;

import com.squidco.demo.entity.Account;

public interface AccountService {
    
    public void save(Account account);

    public List<Account> findAll();

}
