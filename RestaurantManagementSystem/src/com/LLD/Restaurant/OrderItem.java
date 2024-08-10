package com.LLD.Restaurant;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public class OrderItem {
    private String id;
    private String customerId;
    private OrderStatus status;
    private List<MenuItem> items;
    private double totalAmount;
    private Timestamp orderedAt;

    public OrderItem(String id, String customerId, OrderStatus status, List<MenuItem> items, Timestamp orderedAt) {
        this.id = id;
        this.customerId = customerId;
        this.status = status;
        this.items = items;
        this.orderedAt = orderedAt;
        this.totalAmount = calculateTotalAmount(items);
    }

    public OrderItem() {
    }

    private double calculateTotalAmount(List<MenuItem> items) {
        double total = 0.00;
        for(MenuItem item : items){
            total+=item.getPrice();
        }
        return total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Timestamp getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(Timestamp orderedAt) {
        this.orderedAt = orderedAt;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id='" + id + '\'' +
                ", status=" + status +
                ", items=" + items +
                ", totalAmount=" + totalAmount +
                ", orderedAt=" + orderedAt +
                '}';
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
