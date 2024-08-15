package com.project;

import com.project.Vehicle.AvailabilityStatus;
import com.project.Vehicle.Vehicle;
import com.project.Vehicle.VehicleType;

public class ParkingSpot {

    private int spotId;
    private VehicleType type;
    private Vehicle parkedVehicle;
    private AvailabilityStatus status;

    public ParkingSpot() {
    }

    public ParkingSpot(int id) {
        this.spotId = id;
        this.type = VehicleType.CAR;
        this.status = AvailabilityStatus.AVAILABLE;
    }

    public int getSpotId() {
        return spotId;
    }

    public VehicleType getType() {
        return type;
    }

    public AvailabilityStatus getStatus() {
        return status;
    }

    public boolean isAvailable() {
        return parkedVehicle==null;
    }

    public void parkVehicle(Vehicle vehicle) {
        status = AvailabilityStatus.OCCUPIED;
        parkedVehicle = vehicle;
    }

    public void unparkVehicle(Vehicle vehicle) {
        status = AvailabilityStatus.AVAILABLE;
        parkedVehicle = null;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotId=" + spotId +
                ", type=" + type +
                ", parkedVehicle=" + parkedVehicle +
                ", status=" + status +
                '}';
    }
}
