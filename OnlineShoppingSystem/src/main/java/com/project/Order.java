package com.project;

import java.sql.Timestamp;
import java.util.List;

public class Order {
    private String orderId;
    private String userId;
    private List<OrderItem> items;
    private double totalAmount;
    private OrderStatus status;
    private Timestamp createdAt;
    private Timestamp updatedAt;

}
