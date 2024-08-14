package com.project;

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

    public boolean isAvailable() {
        return parkedVehicle==null;
    }

    public void parkVehicle(Vehicle vehicle) {
        status = AvailabilityStatus.OCCUPIED;
        parkedVehicle = vehicle;
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
