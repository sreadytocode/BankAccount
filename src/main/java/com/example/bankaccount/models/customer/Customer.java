package com.example.bankaccount.models.customer;

import com.example.bankaccount.models.allenums.Title;

public class Customer extends Person{
    private double monthlyWage;
    public Customer(Title title, String firstName, String lastName, int age, String address, Double monthlyWage) {
        super(title, firstName, lastName, age, address);
        this.monthlyWage = monthlyWage;
    }

    public double getMonthlyWage() {
        return monthlyWage;
    }

    public void setMonthlyWage(double monthlyWage) {
        this.monthlyWage = monthlyWage;
    }
}
