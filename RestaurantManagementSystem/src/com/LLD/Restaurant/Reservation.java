package com.LLD.Restaurant;

import java.sql.Timestamp;

public class Reservation {
    private String id;
    private String username;
    private String contact;
    private int numberOfPeople;
    private Timestamp bookingDate;

    public Reservation(String id, String username, String contact, int numberOfPeople, Timestamp bookingDate) {
        this.id = id;
        this.username = username;
        this.contact = contact;
        this.numberOfPeople = numberOfPeople;
        this.bookingDate = bookingDate;
    }
}
