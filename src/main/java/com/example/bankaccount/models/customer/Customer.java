package com.example.bankaccount.models.customer;

import com.example.bankaccount.models.allenums.Title;
import com.example.bankaccount.models.bankaccounts.BankAccount;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Title title;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private int age;
    @Column
    private String address;

    @Column
    private double monthlyWage;

    @JsonIgnoreProperties({"customer"})
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private ArrayList<BankAccount> bankAccounts;

    public Customer(Title title, String firstName, String lastName, int age, String address, double monthlyWage, ArrayList<BankAccount> bankAccounts) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.monthlyWage = monthlyWage;
        this.bankAccounts = bankAccounts;
    }

    public Customer() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMonthlyWage() {
        return monthlyWage;
    }

    public void setMonthlyWage(double monthlyWage) {
        this.monthlyWage = monthlyWage;
    }

    public ArrayList<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(ArrayList<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public int getBankAccountsCount(){
        return this.bankAccounts.size();
    }
}
