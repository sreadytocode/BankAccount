package com.example.bankaccount;

import com.example.bankaccount.models.allenums.Card;
import com.example.bankaccount.models.allenums.Title;
import com.example.bankaccount.models.allenums.Type;
import com.example.bankaccount.models.bankaccounts.BankAccount;
import com.example.bankaccount.models.bankaccounts.Transaction;
import com.example.bankaccount.models.customer.Customer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    Customer customer;

    BankAccount bankAccount;

    Transaction transaction;

    @Before
    public void before(){
        ArrayList<Transaction> transactions = new ArrayList<>();
        Transaction transaction = new Transaction("12/02/2023", 14.00, Type.INCOMING, "Calanthe", 50.0, "TOKEEPTHEPEACE", bankAccount);
        Transaction transaction1 = new Transaction("05/10/2023", 10.00, Type.INCOMING, "Bloody Baron", 50.0, "FAMILYMATTERS", bankAccount);
        transactions.add(transaction);
        transactions.add(transaction1);

        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        BankAccount bankAccount1 = new BankAccount(customer, 639268, "11-23-54", Card.VISA, 1000.0, transactions);
        bankAccounts.add(bankAccount1);

        customer = new Customer(Title.MR, "Geralt", "Rivia", 36, "Kaer Morhen", 100.00, bankAccounts);
    }
    @Test
    public void doesCustomerHaveATitle(){
        assertEquals(Title.MR, customer.getTitle());
    }

    @Test
    public void doesCustomerHaveAFirstName(){
        assertEquals("Geralt", customer.getFirstName());
    }

    @Test
    public void doesCustomerHaveALastName(){
        assertEquals("Rivia", customer.getLastName());
    }

    @Test
    public void doesCustomerHaveAnAge(){
        assertEquals(36, customer.getAge());
    }

    @Test
    public void doesCustomerHaveAnAddress(){
        assertEquals("Kaer Morhen", customer.getAddress());
    }

    @Test
    public void doesCustomerHaveAMonthlyWage(){
        assertEquals(100.0, customer.getMonthlyWage(), 0.0);
    }

    @Test
    public void doesCustomerHaveBankAccounts(){
        assertEquals(1, customer.getBankAccountsCount());
    }

}
