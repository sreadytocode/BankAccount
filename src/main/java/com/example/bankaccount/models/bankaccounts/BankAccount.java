package com.example.bankaccount.models.bankaccounts;

import com.example.bankaccount.models.allenums.Card;
import jakarta.persistence.*;

@Entity
@Table(name = "bank")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer accountNumber;

    @Column
    private String sortCode;

    Card card;


    public BankAccount(Integer accountNumber, String sortCode, Card card) {
        this.accountNumber = accountNumber;
        this.sortCode = sortCode;
        this.card = card;
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

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
