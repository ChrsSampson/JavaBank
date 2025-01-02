package com.squidco.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.squidco.demo.entity.Account;
import com.squidco.demo.repository.AccountRepo;
import com.squidco.demo.repository.UserRepo;

// ---- Remember to annotate service to init the bean  ---------------
@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepo repo;

    public AccountServiceImpl(AccountRepo accountRepo, UserRepo usrRepo) {
        repo = accountRepo;
    }

    @Override
    public List<Account> findAll() {
        return repo.findAll();
    }

    @Override
    public void save(Account account) {

       repo.save(account);

    }
    
}
