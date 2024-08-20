package com.project;

public class ShoppingCartItem {
    private String cartItemId;
    private Product product;
    private int quantity;

    public ShoppingCartItem(String cartItemId, Product product, int quantity) {
        this.cartItemId = cartItemId;
        this.product = product;
        this.quantity = quantity;
    }

    public String getCartItemId() {
        return cartItemId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void incrementQuantity(int amount) {
        this.quantity += amount;
    }

    @Override
    public String toString() {
        return "ShoppingCartItem{" +
                "cartItemId='" + cartItemId + '\'' +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
