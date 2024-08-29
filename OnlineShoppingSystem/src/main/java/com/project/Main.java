package com.project;

import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");
        OnlineShoppingSystem onlineShoppingSystem = OnlineShoppingSystem.getInstance();

        onlineShoppingSystem.createUser(new User("Harish","bhariram01@gmail.com","6383561252","Harish", new Timestamp(System.currentTimeMillis())));
        Thread.sleep(1000);
        onlineShoppingSystem.createUser(new User("Harish","hariramb01@gmail.com","9597952282","Harish", new Timestamp(System.currentTimeMillis())));
        Thread.sleep(2000);
        onlineShoppingSystem.displayUsers();
        onlineShoppingSystem.createProduct(new Product("water bottle","water bottle",65.00,150));
        Thread.sleep(1000);
        onlineShoppingSystem.createProduct(new Product("Pen","Blue pen",5.00,200));
        Thread.sleep(2000);
        onlineShoppingSystem.displayProducts();

        onlineShoppingSystem.createShoppingCart("U1");
        Thread.sleep(5000);
        onlineShoppingSystem.createShoppingCart("U2");
        Thread.sleep(5000);
        onlineShoppingSystem.addProductToCart("U1","P1",5);
        Thread.sleep(1000);
        onlineShoppingSystem.addProductToCart("U2","P1",5);
        Thread.sleep(1000);
        onlineShoppingSystem.addProductToCart("U1","P2",5);
        Thread.sleep(1000);
        onlineShoppingSystem.addProductToCart("U2","P2",5);
        Thread.sleep(1000);
        onlineShoppingSystem.displayCartItems("U1");
        Thread.sleep(1000);
        onlineShoppingSystem.displayCartItems("U2");

    }
}