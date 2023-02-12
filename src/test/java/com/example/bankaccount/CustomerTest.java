package com.example.bankaccount;

import com.example.bankaccount.models.allenums.Title;
import com.example.bankaccount.models.bankaccounts.BankAccount;
import com.example.bankaccount.models.customer.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    Customer customer;

    BankAccount bankAccount;

    @Before
    public void before(){
        customer = new Customer(Title.MR, "Geralt", "Rivia", 36, "Kaer Morhen", 100.00);
    }
    @Test
    public void CustomerHasTitle(){
        assertEquals(Title.MR, customer.getTitle());
    }

    @Test
    public void CustomerHasFirstName(){
        assertEquals("Geralt", customer.getFirstName());
    }

    @Test
    public void CustomerHasLastName(){
        assertEquals("Rivia", customer.getLastName());
    }

    @Test
    public void CustomerHasAge(){
        assertEquals(36, customer.getAge());
    }

    @Test
    public void CustomerHasAddress(){
        assertEquals("Kaer Morhen", customer.getAddress());
    }

    @Test
    public void CustomerHasMonthlyWage(){
        assertEquals(100.0, customer.getMonthlyWage(), 0.0);
    }

}
