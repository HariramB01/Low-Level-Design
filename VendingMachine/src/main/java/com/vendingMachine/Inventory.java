package com.vendingMachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private static Map<String, Product> inventory;

    public Inventory() {
        inventory = new HashMap<>();
    }

    public static Map<String, Product> getInventory() {
        return inventory;
    }

    public static void setInventory(Map<String, Product> inventory) {
        Inventory.inventory = inventory;
    }

    public void addProduct(Product product) {
        inventory.put(product.getName(), product);
    }

    public Product getProduct(String productName) {
        return inventory.get(productName);
    }
}
