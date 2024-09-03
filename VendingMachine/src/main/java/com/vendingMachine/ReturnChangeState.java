package com.vendingMachine;

public class ReturnChangeState implements MachineState{


    private final VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine){
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
