package com.example.bankaccount;

import com.example.bankaccount.models.allenums.Card;
import com.example.bankaccount.models.allenums.Type;
import com.example.bankaccount.models.bankaccounts.BankAccount;
import com.example.bankaccount.models.bankaccounts.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BankAccountTest {
    BankAccount bankAccount;

    @Before
    public void before(){
        Transaction transaction1 = new Transaction("12/02/2023", 14.00, Type.INCOMING, "Calanthe", 50.0, "TOKEEPTHEPEACE");
        Transaction transaction2 = new Transaction("05/10/2023", 10.00, Type.INCOMING, "Bloody Baron", 50.0, "FAMILYMATTERS");
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);

        bankAccount = new BankAccount(639268, "11-23-54", Card.VISA, 1000.0, transactions);
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
    public void doesBankAccountHaveTransactions(){
        assertEquals(2, bankAccount.getTransactionCount());
    }


}
