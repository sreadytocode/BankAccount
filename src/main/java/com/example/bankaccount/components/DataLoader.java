package com.example.bankaccount.components;

import com.example.bankaccount.models.allenums.Card;
import com.example.bankaccount.models.allenums.Title;
import com.example.bankaccount.models.allenums.Type;
import com.example.bankaccount.models.bankaccounts.BankAccount;
import com.example.bankaccount.models.bankaccounts.Transaction;
import com.example.bankaccount.models.customer.Customer;
import com.example.bankaccount.repositories.BankAccountRepository;
import com.example.bankaccount.repositories.CustomerRepository;
import com.example.bankaccount.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Autowired
    TransactionRepository transactionRepository;


//    BankAccount bankAccount;

    public DataLoader(){}

    public void run(ApplicationArguments args){



//        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
//
//        Customer geralt = new Customer(Title.MR, "Geralt", "Rivia", 36, "Kaer Morhen", 100.00, bankAccounts);
//        customerRepository.save(geralt);
//
//
//
//
//        Transaction calantheTransaction = new Transaction("12/02/2023", 14.00, Type.INCOMING, "Calanthe", 50.0, "TOKEEPTHEPEACE", bankAccount);
//        transactionRepository.save(calantheTransaction);
//        Transaction baronTransaction = new Transaction("05/10/2023", 10.00, Type.INCOMING, "Bloody Baron", 50.0, "FAMILYMATTERS", bankAccount);
//        transactionRepository.save(baronTransaction);
//        List<Transaction> transactions = Arrays.asList(calantheTransaction, baronTransaction);
//
//        BankAccount bankAccount = new BankAccount(geralt, 639268, "11-23-54", Card.VISA, 1000.0, transactions);
//        bankAccounts.add(bankAccount);
//        bankAccountRepository.save(bankAccount);
//


    }
}
