package com.example.bankaccount;

import com.example.bankaccount.models.bankaccounts.BankAccount;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankAccountTest {
    BankAccount bankAccount;

    @Before
    public void before(){
        bankAccount = new BankAccount(639268);
    }

    @Test
    public void BankAccountHasAccountNumber(){
        assertEquals(639268, bankAccount.getAccountNumber(), 0.0);
    }
}
