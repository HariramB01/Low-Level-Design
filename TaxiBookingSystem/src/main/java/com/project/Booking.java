package com.project;

import java.time.LocalDateTime;

public class Booking {

    private String booking_id;
    private String taxi_id;
    private String rider_id;
    private char fromLocation;
    private char toLocation;
    private int distanceTravelled;
    private double amount;
    private PaymentStatus status;
    private LocalDateTime bookingDate;
    private LocalDateTime checkoutTime;

    public Booking() {
    }

    public Booking(String booking_id, String taxi_id, String rider_id, char fromLocation, char toLocation) {
        this.booking_id = booking_id;
        this.taxi_id = taxi_id;
        this.rider_id = rider_id;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
    }

    public String getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(String booking_id) {
        this.booking_id = booking_id;
    }

    public String getTaxi_id() {
        return taxi_id;
    }

    public void setTaxi_id(String taxi_id) {
        this.taxi_id = taxi_id;
    }

    public String getRider_id() {
        return rider_id;
    }

    public void setRider_id(String rider_id) {
        this.rider_id = rider_id;
    }

    public char getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(char fromLocation) {
        this.fromLocation = fromLocation;
    }

    public char getToLocation() {
        return toLocation;
    }

    public void setToLocation(char toLocation) {
        this.toLocation = toLocation;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDateTime getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(LocalDateTime checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "booking_id='" + booking_id + '\'' +
                ", taxi_id='" + taxi_id + '\'' +
                ", rider_id='" + rider_id + '\'' +
                ", fromLocation=" + fromLocation +
                ", toLocation=" + toLocation +
                ", distanceTravelled=" + distanceTravelled +
                ", amount=" + amount +
                ", status=" + status +
                ", bookingDate=" + bookingDate +
                ", checkoutTime=" + checkoutTime +
                '}';
    }
}
