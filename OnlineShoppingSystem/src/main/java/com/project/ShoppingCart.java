package com.project;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private String cartId;
    private String userId;
    private Map<String, ShoppingCartItem> items;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public ShoppingCart(String cartId, String userId) {
        this.cartId = cartId;
        this.userId = userId;
        this.items = new HashMap<>();
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<String, ShoppingCartItem> getItems() {
        return items;
    }

    public void setItems(Map<String, ShoppingCartItem> items) {
        this.items = items;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cartId='" + cartId + '\'' +
                ", userId='" + userId + '\'' +
                ", items=" + items +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public void addProduct(Product product, int quantity) {
        ShoppingCartItem item = items.get(product.getProductId());
        if (item == null) {
            item = new ShoppingCartItem("CI" + (items.size() + 1), product, quantity);
            items.put(product.getProductId(), item);
        } else {
            item.incrementQuantity(quantity);
        }
    }

    public void displayItems() {
        for (ShoppingCartItem item : items.values()) {
            System.out.println(item.toString());
        }
    }
}
