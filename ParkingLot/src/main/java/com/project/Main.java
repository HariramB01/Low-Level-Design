package com.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        System.out.println("Hello world!");
        Scanner sc = new Scanner(System.in);

        parkingLot.createParkingLot(new ParkingLevel("F01",10)); //number of floors;
        parkingLot.createParkingLot(new ParkingLevel("F02",10 ));
        parkingLot.display();

        parkingLot.parkVehicle("SF013",new Vehicle("Car01","TN-25-HR-2001",VehicleType.CAR));
        System.out.println("--------------------------------");
        parkingLot.parkVehicle("SF023",new Vehicle("Car01","TN-25-HR-2001",VehicleType.CAR));
        System.out.println("--------------------------------");
        parkingLot.parkVehicle("SF011",new Vehicle("Car01","TN-25-HR-2001",VehicleType.CAR));
        System.out.println("--------------------------------");
        parkingLot.parkVehicle("SF012",new Vehicle("Car01","TN-25-HR-2001",VehicleType.CAR));

        parkingLot.display();

        System.out.println("--------------------------------");

        parkingLot.displayUpdated();
        System.out.println("--------------------------------");
        parkingLot.unParkVehicle("SF013","Car01");
        System.out.println("--------------------------------");

        parkingLot.display();
        System.out.println("--------------------------------");
        parkingLot.unParkVehicle("SF011","Car01");
        System.out.println("--------------------------------");

        parkingLot.display();
        boolean exit = false;
        while(exit){
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("");
                    break;
                case 2:
                    exit = false;
                    break;
                default:
                    break;
            }
        }
    }
}











/*


ParkingLot

no.of.floors : int

Parking level

floor_id : String
no.of.spots : int

Parking spot

spot_id : String
floor_id : String
vehicle_id : String
type: VehicleType
status : AvailableStatus
price : double

Vehicle

vehicle_id : String
spot_id : String
LicenseNumber : String
type : VehicleType


VehicleType (ENUM)
CAR,
BIKE,
TRUCK


AvailableStatus (ENUM)

AVAILABLE,
OCCUPIED


Booking

booking_id : String
floor_id : String
spot_id : String
vehicle_id : String
amount : double
status : BookingStatus


BookingStatus (ENUM)

PENDING,
CONFIRMED,
CANCELLED




 */