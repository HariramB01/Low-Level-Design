package com.vendingMachine;

public class IdleState implements MachineState{

    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.print("You've selected the : ");
        System.out.println(product.getName());
    }


    @Override
    public void insertAmount(double totalAmount) {

    }


    @Override
    public void dispenseProduct() {

    }

    @Override
    public void returnChange() {

    }
}
