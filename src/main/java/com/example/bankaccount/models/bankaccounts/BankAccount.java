package com.example.bankaccount.models.bankaccounts;

import jakarta.persistence.*;

@Entity
@Table(name = "bank")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer accountNumber;

    public BankAccount(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BankAccount() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        accountNumber = accountNumber;
    }
}
