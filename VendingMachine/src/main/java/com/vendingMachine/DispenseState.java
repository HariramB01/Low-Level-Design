package com.vendingMachine;

public class DispenseState implements MachineState{

    private final VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {

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
