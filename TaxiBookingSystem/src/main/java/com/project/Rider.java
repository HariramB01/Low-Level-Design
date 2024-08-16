package com.project;

public class Rider {

    private String rider_id;
    private String riderName;
    private String contact;
    private String email;
    private String booking_id;


    public Rider() {
    }

    public Rider(String riderName, String contact, String email) {
        this.riderName = riderName;
        this.contact = contact;
        this.email = email;
        this.booking_id = null;
    }


    public String getRider_id() {
        return rider_id;
    }

    public void setRider_id(String rider_id) {
        this.rider_id = rider_id;
    }

    public String getRiderName() {
        return riderName;
    }

    public void setRiderName(String riderName) {
        this.riderName = riderName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(String booking_id) {
        this.booking_id = booking_id;
    }

    @Override
    public String toString() {
        return "Rider{" +
                "rider_id='" + rider_id + '\'' +
                ", riderName='" + riderName + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", booking_id='" + booking_id + '\'' +
                '}';
    }
}
