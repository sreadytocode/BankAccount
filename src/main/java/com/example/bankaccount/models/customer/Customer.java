package com.example.bankaccount.models.customer;

import com.example.bankaccount.models.allenums.Title;

public class Customer extends Person{
    public Customer(Title title, String firstName, String lastName, int age, String address) {
        super(title, firstName, lastName, age, address);
    }
}
