package com.squidco.demo.router;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.squidco.demo.entity.Account;
import com.squidco.demo.service.AccountService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("/api/accounts")
@RestController
public class AccountRouter {
    
    private AccountService service;

    public AccountRouter(AccountService accountService){
        service = accountService;
    }


    @PostMapping("")
    public void postMethodName(@RequestBody Account accountData) {
        
        service.save(accountData);        
    }
    
    


}
