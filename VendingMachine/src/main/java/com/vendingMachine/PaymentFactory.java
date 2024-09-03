package com.vendingMachine;

public class PaymentFactory {

    public static Payment choosePaymentType(String type){
        switch(type){
            case "Coin":
                return new Coin();
            case "Note ":
                return new Note();
            default:
                return null;
        }
    }

}
