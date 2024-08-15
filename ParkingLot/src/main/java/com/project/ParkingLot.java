package com.project;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private static ParkingLot instance = new ParkingLot();

    public static ParkingLot getInstance() {
        return instance;
    }

    private Map<String, ParkingLevel> parkingLevels = new HashMap<>();
    private Map<String, ParkingSpot> parkingSpots = new HashMap<>();
    private Map<String, Vehicle> vehicles = new HashMap<>();
    private Map<String, Booking> bookings = new HashMap<>();

    public void createParkingLot(ParkingLevel parkingLevel) {
        parkingLevels.put(parkingLevel.getFloor_id(), parkingLevel);
        createParkingSlots(parkingLevel);
    }

    private void createParkingSlots(ParkingLevel parkingLevel) {
        int noOfSpots = parkingLevel.getNoOfSpots();
        String floorId = parkingLevel.getFloor_id();

        int bikeThreshold = (noOfSpots * 20) / 100;
        int carThreshold = bikeThreshold + (noOfSpots * 30) / 100;

        for (int i = 1; i <= noOfSpots; i++) {
            ParkingSpot spot = new ParkingSpot();
            spot.setFloor_id(floorId);
            spot.setSpot_id("S" + floorId + i);
            spot.setStatus(AvailableStatus.AVAILABLE);

            if (i <= bikeThreshold) {
                spot.setType(VehicleType.BIKE);
                spot.setPrice(20.00);
            } else if (i <= carThreshold) {
                spot.setType(VehicleType.CAR);
                spot.setPrice(30.00);
            } else {
                spot.setType(VehicleType.TRUCK);
                spot.setPrice(50.00);
            }

            parkingSpots.put(spot.getSpot_id(), spot);
        }
    }

    public void display() {
        for (String floorId : parkingLevels.keySet()) {
            ParkingLevel level = parkingLevels.get(floorId);
            System.out.println("Floor ID: " + floorId + ", Number of Spots: " + level.getNoOfSpots());

            for (int i = 1; i <= level.getNoOfSpots(); i++) {
                String spotId = "S" + floorId + i;
                ParkingSpot spot = parkingSpots.get(spotId);

                if (spot != null) {
                    System.out.println("Spot ID: " + spot.getSpot_id() +
                            ", Vehicle Type: " + spot.getType() +
                            ", Status: " + spot.getStatus() +
                            ", Date&Time: " + spot.getDate() +
                            ", Price: $" + spot.getPrice());
                }
            }
            System.out.println(); // Add a blank line between floors for readability
        }
    }

    public void displayUpdated(){
        for(String spotId : parkingSpots.keySet()){
            ParkingSpot spot = parkingSpots.get(spotId);
            if(spot!=null && spot.getStatus()==AvailableStatus.OCCUPIED){
                System.out.println("Spot ID: " + spot.getSpot_id() +
                        ", Vehicle Id: " + spot.getVehicle_id() +
                        ", Vehicle Type: " + spot.getType() +
                        ", Status: " + spot.getStatus() +
                        ", Price: $" + spot.getPrice());
            }
        }
    }

    public void parkVehicle(String spot_id, Vehicle vehicle) {
        ParkingSpot spot = parkingSpots.get(spot_id);
        if (spot != null && spot.getStatus() == AvailableStatus.AVAILABLE) {
            spot.setStatus(AvailableStatus.OCCUPIED);
            spot.setVehicle_id(vehicle.getVehicleId());
            spot.setDate(LocalDateTime.now());

            vehicle.setSpot_id(spot_id);
            vehicles.put(vehicle.getVehicleId(), vehicle);

            Booking booking = new Booking(vehicle.getVehicleId(), spot.getFloor_id(), spot_id, spot.getPrice());
            bookings.put(vehicle.getVehicleId(), booking);

            System.out.println("Vehicle parked successfully:");
            System.out.println("Booking ID: " + booking.getBookingId());
            System.out.println("Vehicle ID: " + vehicle.getVehicleId());
            System.out.println("License Number: " + vehicle.getLicenseNumber());
            System.out.println("Vehicle Type: " + vehicle.getType());
            System.out.println("Floor ID: " + spot.getFloor_id());
            System.out.println("Spot ID: " + spot_id);
            System.out.println("Price: $" + spot.getPrice());
            System.out.println("Status: " + spot.getStatus());
            System.out.println("parked date and time: " + spot.getDate());
        } else {
            System.out.println("Error: Spot is not available or does not exist.");
        }
    }

    public void unParkVehicle(String spot_id, String vehicle_id) {
        ParkingSpot spot = parkingSpots.get(spot_id);
        if (spot != null && spot.getStatus() == AvailableStatus.OCCUPIED) {
            spot.setVehicle_id(null);
            spot.setStatus(AvailableStatus.AVAILABLE);
            spot.setDate(null);

            Booking booking = bookings.get(vehicle_id);
            if (booking != null) {
                booking.setStatus(BookingStatus.PAID);

                System.out.println("Vehicle unparked successfully:");
                System.out.println(booking.getBookingId());
                System.out.println("Vehicle ID: " + vehicle_id);
                System.out.println("Spot ID: " + spot_id);
                System.out.println("Price: $" + spot.getPrice());
                System.out.println("Status: " + spot.getStatus());
                System.out.println(LocalDateTime.now());
            } else {
                System.out.println("Error: Booking not found for vehicle ID: " + vehicle_id);
            }
        } else {
            System.out.println("Error: Spot is not occupied or does not exist.");
        }
    }
}
