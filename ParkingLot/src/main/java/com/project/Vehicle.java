package com.project;

public class Vehicle {
    private String vehicleId;
    private String licenseNumber;
    private VehicleType type;
    private String spot_id;

    public Vehicle(String vehicleId, String licenseNumber, VehicleType type) {
        this.vehicleId = vehicleId;
        this.licenseNumber = licenseNumber;
        this.type = type;
    }
    public void setSpot_id(String spot_id) {
        this.spot_id = spot_id;
    }


    public String getVehicleId() {
        return vehicleId;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public String getSpot_id() {
        return spot_id;
    }
}
