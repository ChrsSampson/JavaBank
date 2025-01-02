package com.squidco.demo.router;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.squidco.demo.entity.Account;
import com.squidco.demo.service.AccountService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequestMapping("/api/accounts")
@RestController
public class AccountRouter {
    
    private AccountService service;

    public AccountRouter(AccountService accountService){
        service = accountService;
    }

    @GetMapping("")
    public List<Account> getAllRoute() {
        return service.findAll();
    }
    

    @PostMapping("")
    public void postMethodName(@RequestBody Account accountData) {
        service.save(accountData);        
    }

}
