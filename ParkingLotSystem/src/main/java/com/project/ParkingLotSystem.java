package com.project;

import com.project.Vehicle.Bike;
import com.project.Vehicle.Car;
import com.project.Vehicle.Truck;
import com.project.Vehicle.Vehicle;

import java.util.Scanner;

public class ParkingLotSystem {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();

//        parkingLot.addNewLevelInLot(new ParkingLevel(1,2));
//        parkingLot.addNewLevelInLot(new ParkingLevel(2,3));

        Vehicle car = new Car("Car01");
        Vehicle truck = new Truck("Truck01");
        Vehicle bike = new Bike("Bike01");
        Vehicle car1 = new Car("Car02");

//        if(parkingLot.parkVehicle(car)){
//            System.out.println("Vehicle parked successfully");
//        }
//        else{
//            System.out.println("vehicle didn't parked");
//        }

//        parkingLot.display();

//        if(parkingLot.unparkVehicle(car)){
//            System.out.println("Vehicle unparked successfully");
//        }
//        else{
//            System.out.println("vehicle didn't unparked");
//        }

//        parkingLot.display();

//        System.out.println("-------------------------------");
//        System.out.println("-------------------------------");

//        parkingLot.displayAvailablity();

        Scanner sc = new Scanner(System.in);
        boolean exit = true;
        while(exit){
            System.out.println("Enter 1 for Create parking Level");
            System.out.println("Enter 2 for vehicle details");
            System.out.println("Enter 3 for park vehicle");
            System.out.println("Enter 4 for unpark vehicle");
            System.out.println("Enter 5 for display parkingLot");
            System.out.println("Enter 6 for display availability");
            System.out.println("Enter 7 for exit");
            System.out.print("choose the option: ");
            int option = sc.nextInt();
            switch (option){
                case 1:
                    System.out.println("Enter the floor: ");
                    int floor = sc.nextInt();
                    System.out.println("Enter the numberOfSpots: ");
                    int numberOfSpots = sc.nextInt();
                    parkingLot.addNewLevelInLot(new ParkingLevel(floor,numberOfSpots));
                    System.out.println("-------------------------------");
                    break;
//                case 2:
//                    System.out.println("Enter 1 for car: ");
//                    System.out.println("Enter 2 for bike: ");
//                    System.out.println("Enter 3 for truck: ");
//                    int choice = sc.nextInt();
//                    System.out.println("Enter your license Number: ");
//                    String licenseNumber = sc.nextLine();
//                    switch(choice){
//                        case 1:
//                            Vehicle car = new Car(licenseNumber);
//                            if(parkingLot.addVehicle(licenseNumber,car)){
//                                System.out.println("Vehicle details added successfully");
//                            }
//                            else{
//                                System.out.println("Invalid");
//                            }
//                            break;
//                        case 2:
//                            Vehicle bike = new Bike(licenseNumber);
//                            if(parkingLot.addVehicle(licenseNumber,bike)){
//                                System.out.println("Vehicle details added successfully");
//                            }
//                            else{
//                                System.out.println("Invalid");
//                            }
//                            break;
//                        case 3:
//                            Vehicle truck = new Truck(licenseNumber);
//                            if(parkingLot.addVehicle(licenseNumber,truck)){
//                                System.out.println("Vehicle details added successfully");
//                            }
//                            else{
//                                System.out.println("Invalid");
//                            }
//                            break;
//                    }
//                    System.out.println("-------------------------------");
//                    break;
                case 3:
//                    System.out.println("Enter the license Number: ");
//                    String license = sc.next();
                    if(parkingLot.parkVehicle(car)){
                        System.out.println("Vehicle parked successfully");
                    }
                    else{
                        System.out.println("vehicle didn't parked");
                    }
                    System.out.println("-------------------------------");
                    break;
                case 4:
                    if(parkingLot.unparkVehicle(car)){
                        System.out.println("Vehicle unparked successfully");
                    }
                    else{
                        System.out.println("vehicle didn't unparked");
                    }
                    System.out.println("-------------------------------");
                    break;
                case 5:
                    parkingLot.display();
                    System.out.println("-------------------------------");
                    break;
                case 6:
                    ParkingLevel.displayAvailablity();
                    System.out.println("-------------------------------");
                    break;
                case 7:
                    System.out.println("Exit");
                    exit = false;
                    break;
                default:
                    System.out.println("Enter valid option");
                    System.out.println("-------------------------------");
                    break;
            }
        }
        sc.close();
    }
}