package com.project;

import java.sql.Timestamp;

public class OrderItem {
    private String orderItemId;
    private String orderId;
    private String productId;
    private int quantity;
    private double price;
    private double totalPrice;
    private Timestamp createdAt;
}
