package com.example.bankaccount.controllers;

import com.example.bankaccount.models.bankaccounts.Transaction;
import com.example.bankaccount.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping(value = "/transactions")
    public ResponseEntity<List<Transaction>> getAllTransactions(){
        return new ResponseEntity<>(transactionRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/transactions/{id}")
    public ResponseEntity getTransaction(@PathVariable Long id){
        return new ResponseEntity<>(transactionRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/transactions")
    public ResponseEntity<Transaction> postTransactions(@RequestBody Transaction transaction){
        transactionRepository.save(transaction);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }
}
