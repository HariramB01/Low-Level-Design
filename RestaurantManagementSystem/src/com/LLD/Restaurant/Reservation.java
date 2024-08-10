package com.LLD.Restaurant;

import java.sql.Timestamp;

public class Reservation {
    private String id;
    private String customerId;
    private int numberOfPeople;
    private TableType type;
    private Timestamp bookingDate;

    public Reservation(String id, String customerId, int numberOfPeople, Timestamp bookingDate) {
        this.id = id;
        this.customerId = customerId;
        this.numberOfPeople = numberOfPeople;
        this.bookingDate = bookingDate;
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

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public Timestamp getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Timestamp bookingDate) {
        this.bookingDate = bookingDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", numberOfPeople=" + numberOfPeople +
                ", bookingDate=" + bookingDate +
                '}';
    }
}
