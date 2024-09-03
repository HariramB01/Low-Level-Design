package com.vendingMachine;

public interface MachineState {

    void selectProduct(Product product);

    void insertAmount(double amount);

    void dispenseProduct();

    void returnChange();


}
