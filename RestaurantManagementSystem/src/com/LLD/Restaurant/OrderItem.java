package com.LLD.Restaurant;

import java.sql.Timestamp;
import java.time.LocalDate;

public class OrderItem {
    private String id;
    private OrderStatus status;
    private double amount;
    private Timestamp orderedAt;

    public OrderItem(String id, OrderStatus status, double amount, Timestamp orderedAt) {
        this.id = id;
        this.status = status;
        this.amount = amount;
        this.orderedAt = orderedAt;
    }
}
