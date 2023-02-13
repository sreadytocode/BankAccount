package com.example.bankaccount.models.behaviours;

import com.example.bankaccount.models.bankaccounts.Transaction;

public interface IReceive {
    double receivePayment(Transaction transaction);
}
