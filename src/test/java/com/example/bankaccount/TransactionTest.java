package com.example.bankaccount;

import jakarta.transaction.Transaction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransactionTest {
    Transaction transaction;

    @Before
    public void before(){
        transaction = new Transaction("12/02/2023");
    }
    @Test
    public void TransactionHasDate(){
        assertEquals("12/02/2023", transaction.getDate());
    }
}
