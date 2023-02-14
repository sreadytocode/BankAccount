package com.example.bankaccount.controllers;

import com.example.bankaccount.models.bankaccounts.BankAccount;
import com.example.bankaccount.models.customer.Customer;
import com.example.bankaccount.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/bankAccounts")
    public ResponseEntity<BankAccount> postBankAccounts(@RequestBody BankAccount bankAccount){
        bankAccountRepository.save(bankAccount);
        return new ResponseEntity<>(bankAccount, HttpStatus.CREATED);
    }

    @PutMapping(value = "/bankAccounts/{id}")
    public ResponseEntity<BankAccount> putBankAccount(@RequestBody BankAccount bankAccount, @PathVariable Long id){
        BankAccount bankAccountToUpdate = bankAccountRepository.findById(id).get();
        bankAccountToUpdate.setCustomer(bankAccount.getCustomer());
        bankAccountToUpdate.setAccountNumber(bankAccount.getAccountNumber());
        bankAccountToUpdate.setSortCode(bankAccount.getSortCode());
        bankAccountToUpdate.setCard(bankAccount.getCard());
        bankAccountToUpdate.setCash(bankAccount.getCash());
        bankAccountToUpdate.setTransactions(bankAccount.getTransactions());
        return new ResponseEntity<>(bankAccountToUpdate, HttpStatus.OK);
    }

    @DeleteMapping(value = "/bankAccounts/{id}")
    public ResponseEntity<Long> deleteBankAccounts(@PathVariable Long id){
        bankAccountRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
