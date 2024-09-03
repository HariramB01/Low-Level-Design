package com.vendingMachine;


public class VendingMachineApp
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        VendingMachine machine = VendingMachine.getInstance();

        machine.inventory.addProduct(new Product("Coke",50.00));
        machine.inventory.addProduct(new Product("Pepsi",60.00));
        machine.inventory.addProduct(new Product("SevenUp",70.00));
        machine.inventory.addProduct(new Product("Cola",80.00));

        machine.selectProduct("Coke");
        Payment paymentType = PaymentFactory.choosePaymentType("Coin");
        machine.insertAmount(paymentType.getMoney(10,4));



    }
}
