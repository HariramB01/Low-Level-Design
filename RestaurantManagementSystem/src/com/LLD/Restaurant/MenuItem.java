package com.LLD.Restaurant;

public class MenuItem {
    private String id;
    private String item;
    private String description;
    private double price;
    private boolean available;

    public MenuItem(String id, String item, String description, double price, boolean available) {
        this.id = id;
        this.item = item;
        this.description = description;
        this.price = price;
        this.available = available;
    }
}
