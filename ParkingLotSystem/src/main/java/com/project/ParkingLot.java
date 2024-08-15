package com.project;

import com.project.Vehicle.Vehicle;

import java.util.*;

public class ParkingLot {
    private static ParkingLot instance = new ParkingLot();

    private List<ParkingLevel> levels;


    public static ParkingLot getInstance() {
        return instance;
    }

    public ParkingLot(){
        levels = new ArrayList<>();
    }


    public void addNewLevelInLot(ParkingLevel parkingLevel) {
        levels.add(parkingLevel);
    }

    public void display() {
        for(ParkingLevel level : levels){
            System.out.println(level.toString());
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for(ParkingLevel level : levels){
            if(level.parkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        for(ParkingLevel level : levels){
            if(level.unParkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }

    public boolean addVehicle(String licenseNumber, Vehicle car) {
        return true;
    }
//
//    public void displayAvailablity() {
//        for(ParkingLevel level : levels){
//            if(level.displayAvailability()){
//                System.out.println(level.toString());
//            }
//        }
//    }
}