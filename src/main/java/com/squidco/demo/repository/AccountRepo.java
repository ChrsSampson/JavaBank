package com.squidco.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.squidco.demo.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Long> {

}
