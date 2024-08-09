package com.LLD.Payment;

public class CreditCard implements Payment{
    @Override
    public boolean processPayment(double price) {
        return true;
    }
}
