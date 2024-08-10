package com.LLD.Restaurant;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Reservation {
    private String id;
    private String customerId;
    private int numberOfPeople;
    private TableType type;
    private LocalDateTime bookingDate;

    public Reservation(String id, String customerId, int numberOfPeople, TableType type, LocalDateTime bookingDate) {
        this.id = id;
        this.customerId = customerId;
        this.numberOfPeople = numberOfPeople;
        this.type = type;
        this.bookingDate = bookingDate;
    }

    public Reservation() {

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

    public TableType getType() {
        return type;
    }

    public void setType(TableType type) {
        this.type = type;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", numberOfPeople=" + numberOfPeople +
                ", type=" + type +
                ", bookingDate=" + bookingDate +
                '}';
    }
}
