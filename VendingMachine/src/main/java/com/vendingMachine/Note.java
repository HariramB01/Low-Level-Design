package com.vendingMachine;

public class Note implements Payment {


    public double getMoney(double amount, int numberOfCoins) {
       return amount*numberOfCoins;
    }
}
