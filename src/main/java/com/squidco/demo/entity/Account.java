package com.squidco.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {

    public enum AccountType {
        checking,
        saving;
    }

    // default constructor
    public Account() {}


    public Account(User user, AccountType accountType, double balance) {
        this.user = user;
        this.accountType = accountType;
        this.balance = balance;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @OneToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    // @Column(name="user_id")
    // private long userId;

    @Column(name="account_type")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(name="balance")
    private double balance;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User getUser() {
       return user;
    }

    public void setUser(User user) {
        this.user = user;
    } 

    @Override
    public String toString() {
        return "Accounts [id=" + id + ", userId=" + user.getId() + ", accountType=" + accountType + ", balance=" + balance
                + ", user=" + user + "]";
    }

}
