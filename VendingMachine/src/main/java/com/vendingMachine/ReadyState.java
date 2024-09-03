package com.vendingMachine;

public class ReadyState implements MachineState{

    private final VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("product already selected, please make a payment");
    }

    @Override
    public void insertAmount(double totalAmount) {

        vendingMachine.addTotalAmount(totalAmount);
        System.out.println("Amount added to your account");
        checkPaymentStatus();
    }

    private void checkPaymentStatus() {
        if(vendingMachine.getTotalAmount()>=vendingMachine.getSelectedProduct().getPrice()){
            vendingMachine.setCurrentState(vendingMachine.getDispenseState());
        }
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Insert the amount first!!!");
    }

    @Override
    public void returnChange() {

    }
}
