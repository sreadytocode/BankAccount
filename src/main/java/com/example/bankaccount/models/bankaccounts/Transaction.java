package com.example.bankaccount.models.bankaccounts;

import com.example.bankaccount.models.allenums.Type;
import jakarta.persistence.*;

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

    public Transaction(String date, Double time, Type type, String recipient, Double amount) {
        this.date = date;
        this.time = time;
        this.type = type;
        this.recipient = recipient;
        this.amount = amount;
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
}
