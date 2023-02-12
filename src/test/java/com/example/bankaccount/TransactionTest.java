package com.example.bankaccount;

import com.example.bankaccount.models.bankaccounts.Transaction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransactionTest {
    Transaction transaction;

    @Before
    public void before(){
        transaction = new Transaction("12/02/2023", 14.00, Type.INCOMING);
    }
    @Test
    public void TransactionHasDate(){
        assertEquals("12/02/2023", transaction.getDate());
    }

    @Test
    public void TransactionHasTime(){
        assertEquals(14.00, transaction.getTime(), 0.0);
    }

    @Test
    public void TransationHasType(){
        assertEquals(Type.INCOMING, transaction.getType());
    }
}
