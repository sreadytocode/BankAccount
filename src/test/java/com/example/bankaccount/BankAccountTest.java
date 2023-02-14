package com.example.bankaccount;

import com.example.bankaccount.models.allenums.Card;
import com.example.bankaccount.models.allenums.Type;
import com.example.bankaccount.models.bankaccounts.BankAccount;
import com.example.bankaccount.models.bankaccounts.Transaction;
import com.example.bankaccount.models.customer.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BankAccountTest {
    BankAccount bankAccount;

    Transaction calantheTransaction;

    Transaction baronTransaction;

    Customer customer;

    @Before
    public void before(){

        calantheTransaction = new Transaction("2023-02-05", 14.00, Type.INCOMING, "Calanthe", 50.0, "TOKEEPTHEPEACE", bankAccount);
        baronTransaction = new Transaction("2023-02-12", 10.00, Type.INCOMING, "Bloody Baron", 50.0, "FAMILYMATTERS", bankAccount);
        List<Transaction> transactions = Arrays.asList(calantheTransaction, baronTransaction);

        bankAccount = new BankAccount(customer, 639268, "11-23-54", Card.VISA, 1000.0, transactions);
    }

    @Test
    public void doesBankAccountHaveAnAccountNumber(){
        assertEquals(639268, bankAccount.getAccountNumber(), 0.0);
    }

    @Test
    public void doesBankAccountHaveASortCode(){
        assertEquals("11-23-54", bankAccount.getSortCode());
    }

    @Test
    public void doesBankAccountHaveACard(){
        assertEquals(Card.VISA, bankAccount.getCard());
    }

    @Test
    public void doesBankAccountHaveCash(){
        assertEquals(1000.00, bankAccount.getCash(), 0.0);
    }

    @Test
    public void doesBankAccountHaveMoreThanOneTransaction(){
        assertEquals(2, bankAccount.getTransactionsCount());
    }

    @Test
    public void doesBankAccountHaveACustomer(){
        assertEquals(customer, bankAccount.getCustomer());
    }

    @Test
    public void doesBankAccountAllowCustomerToPay(){
        ArrayList<Transaction> newTransactions = new ArrayList<>();
        Transaction merchant = new Transaction("12/02/2023", 10.00, Type.OUTGOING, "Merchant", 10.0, "NEWSHOES", bankAccount);
        newTransactions.add(merchant);

        bankAccount = new BankAccount(customer, 639268, "11-23-54", Card.VISA, 1000.0, newTransactions);

        bankAccount.reduceCash(merchant);

        assertEquals(990, bankAccount.getCash(), 0.0);
    }

    @Test
    public void doesNotAllowCustomerToPayIfTypeIsIncoming(){
        ArrayList<Transaction> recentTransaction = new ArrayList<>();
        Transaction transaction = new Transaction("12/02/2023", 14.00, Type.INCOMING, "Calanthe", 50.0, "TOKEEPTHEPEACE", bankAccount);
        recentTransaction.add(transaction);

        bankAccount = new BankAccount(customer, 639268, "11-23-54", Card.VISA, 1000.0, recentTransaction);
        bankAccount.reduceCash(transaction);

        assertEquals(1000.0, bankAccount.getCash(), 0.0);
    }

    @Test
    public void doesBankAccountAddToCashIfPaymentIncoming(){
        ArrayList<Transaction> recentTransaction = new ArrayList<>();
        Transaction baronTransaction = new Transaction("05/10/2023", 10.00, Type.INCOMING, "Bloody Baron", 50.0, "FAMILYMATTERS", bankAccount);
        recentTransaction.add(baronTransaction);

        bankAccount = new BankAccount(customer, 639268, "11-23-54", Card.VISA, 1000.0, recentTransaction);
        bankAccount.receivePayment(baronTransaction);

        assertEquals(1050.0, bankAccount.getCash(), 0.0);
    }

    @Test
    public void doesNotAddToBankAccountCashIfPaymentOutgoing(){
        ArrayList<Transaction> newTransactions = new ArrayList<>();
        Transaction merchant = new Transaction("12/02/2023", 10.00, Type.OUTGOING, "Merchant", 10.0, "NEWSHOES", bankAccount);
        newTransactions.add(merchant);

        bankAccount = new BankAccount(customer, 639268, "11-23-54", Card.VISA, 1000.0, newTransactions);
        bankAccount.receivePayment(merchant);

        assertEquals(1000.0, bankAccount.getCash(), 0.0);
    }

    @Test
    public void doesBankAccountHaveTransactionByDate(){
        assertEquals(calantheTransaction, bankAccount.findTransactionByDate("12/02/2023"));
    }

    @Test
    public void findTransactionsInBankAccountByDateRange(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String startDate ="01-01-2023";
        LocalDate dateStart = LocalDate.parse(startDate, formatter);
        String endDate = "13-03-2023";
        LocalDate dateEnd = LocalDate.parse(endDate, formatter);
        List<String> expected = Arrays.asList("2023-02-05", "2023-02-12");
        assertEquals(expected, bankAccount.findTransactionsByDateRange(dateStart, dateEnd));
    }


}
