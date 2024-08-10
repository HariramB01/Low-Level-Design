package com.LLD.Payment;

public class Payment {
    private String id;
    private double amount;
    private PaymentMethod method;
    private PaymentStatus status;

    public Payment(String id, double amount, PaymentMethod method, PaymentStatus status) {
        this.id = id;
        this.amount = amount;
        this.method = method;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", method=" + method +
                ", status=" + status +
                '}';
    }
}
