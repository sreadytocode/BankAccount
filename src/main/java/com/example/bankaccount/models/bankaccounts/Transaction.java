package com.example.bankaccount.models.bankaccounts;

import com.example.bankaccount.models.allenums.Type;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String date;

    @Column
    private Double time;

    Type type;

    @Column
    private String recipient;

    @Column
    private Double amount;

    @Column
    private String reference;

    @JsonIgnoreProperties({"transactions"})
    @ManyToOne
    @JoinColumn(name = "bankAccount_id", nullable = false)
    private BankAccount bankAccount;

    public Transaction(String date, Double time, Type type, String recipient, Double amount, String reference, BankAccount bankAccount) {
        this.date = date;
        this.time = time;
        this.type = type;
        this.recipient = recipient;
        this.amount = amount;
        this.reference = reference;
        this.bankAccount = bankAccount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

}
