package com.example.bankaccount.models.bankaccounts;

import jakarta.persistence.*;

@Entity
@Table(name = "bank")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
