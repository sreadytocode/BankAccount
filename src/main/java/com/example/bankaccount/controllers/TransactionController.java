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

    @PutMapping(value = "/transactions/{id}")
    public ResponseEntity<Transaction> putTransaction(@RequestBody Transaction transaction, @PathVariable Long id){
        Transaction transactionToUpdate = transactionRepository.findById(id).get();
        transactionToUpdate.setDate(transaction.getDate());
        transactionToUpdate.setTime(transaction.getTime());
        transactionToUpdate.setType(transaction.getType());
        transactionToUpdate.setRecipient(transaction.getRecipient());
        transactionToUpdate.setAmount(transaction.getAmount());
        transactionToUpdate.setReference(transaction.getReference());
        transactionToUpdate.setBankAccount(transaction.getBankAccount());
        return new ResponseEntity<>(transactionToUpdate, HttpStatus.OK);
    }

    @DeleteMapping(value = "/transactions/{id}")
    public ResponseEntity<Long> deleteTransaction(@PathVariable Long id){
        transactionRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
