package com.squidco.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="accounts")
public class Accounts {

    public enum AccountType {
        checking,
        saving;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="account_id")
    private long id;

    @Column(name="user_id")
    private long userId;

    @Column(name="account_type")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(name="balance")
    private double balance;

    @OneToMany(mappedBy = "accounts")
    private User user;
}
