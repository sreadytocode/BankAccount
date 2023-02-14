package com.example.bankaccount.components;

import com.example.bankaccount.repositories.BankAccountRepository;
import com.example.bankaccount.repositories.CustomerRepository;
import com.example.bankaccount.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public DataLoader(){}

    public void run(ApplicationArguments args){

    }
}
