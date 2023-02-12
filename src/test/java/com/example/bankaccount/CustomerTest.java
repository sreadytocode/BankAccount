package com.example.bankaccount;

import com.example.bankaccount.models.allenums.Title;
import com.example.bankaccount.models.customer.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    Customer customer;

    @Before
    public void before(){
        customer = new Customer(Title.MR, "Geralt", "Rivia", 36, "Kaer Morhen");
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

}
