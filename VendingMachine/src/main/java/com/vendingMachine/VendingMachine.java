package com.vendingMachine;

import java.util.Map;

public class VendingMachine {

    private static VendingMachine instance;
    public Inventory inventory;

    private MachineState readyState;
    private MachineState idleState;
    private MachineState dispenseState;
    private MachineState returnChangeState;
    private MachineState currentState;
    private Product selectedProduct;
    private double totalAmount;
    public PaymentFactory paymentFactory;

    public VendingMachine() {
        inventory = new Inventory();
        readyState = new ReadyState(this);
        idleState = new IdleState(this);
        dispenseState = new DispenseState(this);
        returnChangeState = new ReturnChangeState(this);
        currentState = idleState;
        selectedProduct = null;
        totalAmount = 0.0;
        paymentFactory = new PaymentFactory();
    }

    public static VendingMachine getInstance(){
        if(instance==null){
            instance = new VendingMachine();
        }
        return instance;
    }

    //getters and setters

    public MachineState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(MachineState currentState) {
        this.currentState = currentState;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public MachineState getReturnChangeState() {
        return returnChangeState;
    }

    public void setReturnChangeState(MachineState returnChangeState) {
        this.returnChangeState = returnChangeState;
    }

    public MachineState getDispenseState() {
        return dispenseState;
    }

    public void setDispenseState(MachineState dispenseState) {
        this.dispenseState = dispenseState;
    }

    public MachineState getIdleState() {
        return idleState;
    }

    public void setIdleState(MachineState idleState) {
        this.idleState = idleState;
    }

    public MachineState getReadyState() {
        return readyState;
    }

    public void setReadyState(MachineState readyState) {
        this.readyState = readyState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public PaymentFactory getPaymentFactory() {
        return paymentFactory;
    }

    public void setPaymentFactory(PaymentFactory paymentFactory) {
        this.paymentFactory = paymentFactory;
    }

    // method declarations

    public void selectProduct(String productName){
        Product product = inventory.getProduct(productName);
        if(product!=null){
            currentState.selectProduct(product);
        }
        else{
            System.out.println("please select available product!!!");
        }
    }


    public void insertAmount(double money) {
        currentState.insertAmount(totalAmount);
    }


    public void addTotalAmount(double amount) {
        totalAmount+=amount;
    }



}
