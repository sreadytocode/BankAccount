package com.example.bankaccount.models.bankaccounts;

import com.example.bankaccount.models.allenums.Card;
import com.example.bankaccount.models.allenums.Type;
import com.example.bankaccount.models.behaviours.IPay;
import com.example.bankaccount.models.customer.Customer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bank")
public class BankAccount implements IPay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer accountNumber;

    @Column
    private String sortCode;

    Card card;

    @Column
    private Double cash;

    @JsonIgnoreProperties({"bankAccount"})
    @OneToMany(mappedBy = "bankAccount", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private ArrayList<Transaction> transactions;

    @JsonIgnoreProperties({"bankAccounts"})
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;


    public BankAccount(Customer customer, Integer accountNumber, String sortCode, Card card, Double cash, ArrayList<Transaction> transactions) {
        this.customer = customer;
        this.accountNumber = accountNumber;
        this.sortCode = sortCode;
        this.card = card;
        this.cash = cash;
        this.transactions = transactions;
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
        this.accountNumber = accountNumber;
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

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public int getTransactionsCount(){
        return this.transactions.size();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double reduceCash(Transaction transaction) {
        double total = 0;
        if (transaction.getType() == Type.OUTGOING) {
            total = this.cash -= transaction.getAmount();
        }
        return total;
    }

}
