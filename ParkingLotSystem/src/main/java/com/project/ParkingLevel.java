package com.project;

import com.project.Vehicle.AvailabilityStatus;
import com.project.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLevel {
    private int floor;
    private static List<ParkingSpot> parkingSpots;
    private int availableSpots;

    public ParkingLevel() {
    }

    public ParkingLevel(int floor, int numberOfSpots) {
        this.floor = floor;
        this.availableSpots = numberOfSpots;
        parkingSpots = new ArrayList<>();
        for(int i=1;i<=numberOfSpots;i++){
            parkingSpots.add(new ParkingSpot(i));
        }
    }

    public static void displayAvailablity() {
        for(ParkingSpot spot : parkingSpots){
            if(spot.isAvailable() && spot.getStatus()== AvailabilityStatus.AVAILABLE){
                System.out.println(spot.toString());
            }
        }
    }


    public boolean parkVehicle(Vehicle vehicle) {
        for(ParkingSpot spot : parkingSpots){
            if(spot.isAvailable() && spot.getType()==vehicle.getType()){
                spot.parkVehicle(vehicle);
                --availableSpots;
                return true;
            }
        }
        return false;
    }

    public boolean unParkVehicle(Vehicle vehicle) {
        for(ParkingSpot spot : parkingSpots){
            if(!spot.isAvailable() && spot.getType()==vehicle.getType()){
                spot.unparkVehicle(vehicle);
                availableSpots++;
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "ParkingLevel{" +
                "floor=" + floor +
                ", parkingSpots=" + parkingSpots +
                ", availableSpots=" + availableSpots +
                '}';
    }

}
