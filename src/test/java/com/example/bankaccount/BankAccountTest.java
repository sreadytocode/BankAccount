package com.example.bankaccount;

import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {
    BankAccount bankAccount;

    @Before
    public void before(){
        bankAccount = new BankAccount(008428);
    }

    @Test
    public void BankAccountHasAccountNumber(){
        assertEquals(008428, bankAccount.getAccountNumber());
    }
}
