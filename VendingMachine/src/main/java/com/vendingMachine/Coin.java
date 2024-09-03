package com.vendingMachine;

public class Coin implements Payment {

    public double getMoney(double amount, int numberOfCoins){
        return amount*numberOfCoins;
    }

}
