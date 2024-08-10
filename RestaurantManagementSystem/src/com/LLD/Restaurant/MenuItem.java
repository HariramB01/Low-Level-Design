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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id='" + id + '\'' +
                ", item='" + item + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", available=" + available +
                '}';
    }
}
