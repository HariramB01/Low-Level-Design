package com.project;

public class Taxi {
    private String taxi_Id;
    private String taxiNumber;
    private String rider;
    private String driverName;
    private char location;
    private AvailableStatus status;
    private double price;

    public Taxi() {
    }

    public Taxi(String taxi_Id, String taxiNumber, String driverName, double price) {
        this.taxi_Id = taxi_Id;
        this.taxiNumber = taxiNumber;
        this.rider = null;
        this.driverName = driverName;
        this.location = 'A';
        this.status = AvailableStatus.AVAILABLE;
        this.price = price;
    }

    public String getTaxi_Id() {
        return taxi_Id;
    }

    public void setTaxi_Id(String taxi_Id) {
        this.taxi_Id = taxi_Id;
    }

    public String getTaxiNumber() {
        return taxiNumber;
    }

    public void setTaxiNumber(String taxiNumber) {
        this.taxiNumber = taxiNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public AvailableStatus getStatus() {
        return status;
    }

    public void setStatus(AvailableStatus status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRider() {
        return rider;
    }

    public void setRider(String rider) {
        this.rider = rider;
    }

    public char getLocation() {
        return location;
    }

    public void setLocation(char location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "taxi_Id='" + taxi_Id + '\'' +
                ", taxiNumber='" + taxiNumber + '\'' +
                ", rider='" + rider + '\'' +
                ", driverName='" + driverName + '\'' +
                ", location=" + location +
                ", status=" + status +
                ", price=" + price +
                '}';
    }
}
