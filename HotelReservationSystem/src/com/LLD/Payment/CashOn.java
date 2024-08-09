package com.LLD.Payment;

public class CashOn implements Payment{
    @Override
    public boolean processPayment(double price) {
        return true;
    }
}
