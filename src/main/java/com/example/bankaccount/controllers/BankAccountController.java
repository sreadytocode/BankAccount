package com.example.bankaccount.controllers;

import com.example.bankaccount.models.bankaccounts.BankAccount;
import com.example.bankaccount.models.customer.Customer;
import com.example.bankaccount.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountController {

    @Autowired
    BankAccountRepository bankAccountRepository;

    @GetMapping(value = "/bankAccounts")
    public ResponseEntity<List<BankAccount>> getAllBankAccounts() {
        return new ResponseEntity<>(bankAccountRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/bankAccounts/{id")
    public ResponseEntity getBankAccount(@PathVariable Long id) {
        return new ResponseEntity<>(bankAccountRepository.findById(id), HttpStatus.OK);
    }
}
