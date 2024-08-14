package com.project;

public class ParkingLotSystem {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();

        parkingLot.addNewLevelInLot(new ParkingLevel(1,2));
        parkingLot.addNewLevelInLot(new ParkingLevel(2,3));

        Vehicle car = new Car("Car01");

        if(parkingLot.parkVehicle(car)){
            System.out.println("Vehicle parked successfully");
        }

        parkingLot.display();

    }
}