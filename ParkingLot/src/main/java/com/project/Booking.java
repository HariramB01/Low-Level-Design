package com.project;

import java.time.LocalDateTime;
import java.util.UUID;

public class Booking {
    private String bookingId;
    private String vehicleId;
    private String spotId;
    private String floorId;
    private double price;
    private BookingStatus status;
    private LocalDateTime bookingDate; // Changed to LocalDate

    public Booking(String vehicleId, String spotId, String floorId, double price) {
        this.bookingId = UUID.randomUUID().toString();
        this.vehicleId = vehicleId;
        this.spotId = spotId;
        this.floorId = floorId;
        this.price = price;
        this.status = BookingStatus.PENDING;
        this.bookingDate = LocalDateTime.now(); // Set the current date as the booking date
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getSpotId() {
        return spotId;
    }

    public String getFloorId() {
        return floorId;
    }

    public double getPrice() {
        return price;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
