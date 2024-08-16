package com.project;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TaxiHub {
    private static TaxiHub instance = new TaxiHub();

    public static TaxiHub getInstance(){
        return instance;
    }
    Map<String, Taxi> allTaxis = new LinkedHashMap<>();
    Map<String, Booking> bookings = new LinkedHashMap<>();
    Map<String, Rider> riders = new LinkedHashMap<>();



    public void createTaxis(Taxi taxi) {
        if(!allTaxis.containsKey(taxi.getTaxi_Id())) {
            String formattedId = String.format("T%02d", allTaxis.size() + 1);
            taxi.setTaxi_Id(formattedId);
            allTaxis.put(taxi.getTaxi_Id(), taxi);
//            System.out.println("CReated taxi: "+formattedId);
        }
        else
            System.out.println("Taxi "+taxi.getTaxi_Id()+" already exists");
    }

    public void displayAllTaxis(){
        for(String id : allTaxis.keySet()){
            Taxi taxi = allTaxis.get(id);
            System.out.println(taxi.toString());
        }
    }

    public void bookTaxi(String taxi_id, String rider_id, char from, char to) {

        Booking booking = new Booking();
        String bookingId = String.format("B%s%02d", rider_id, bookings.size() + 1);
        booking.setBooking_id(bookingId);
        booking.setTaxi_id(taxi_id);
        booking.setRider_id(rider_id);
        booking.setFromLocation(from);
        booking.setToLocation(to);
        booking.setDistanceTravelled((to-from)*10);
        booking.setAmount(booking.getDistanceTravelled()*50);
        booking.setStatus(PaymentStatus.PENDING);
        booking.setBookingDate(LocalDateTime.now());
        bookings.put(booking.getBooking_id(), booking);

        Taxi taxi = allTaxis.get(taxi_id);
        taxi.setRider(rider_id);
        taxi.setStatus(AvailableStatus.BOOKED);

        System.out.println(booking.toString());

        System.out.println(taxi.toString());
    }

    public void releaseTaxi(String bookingId) {
        Booking booking = bookings.get(bookingId);
        Rider rider = riders.get(booking.getRider_id());
        Taxi taxi = allTaxis.get(booking.getTaxi_id());
        if(rider!=null && taxi!=null) {
            booking.setCheckoutTime(LocalDateTime.now());
            booking.setStatus(PaymentStatus.COMPLETED);
            taxi.setStatus(AvailableStatus.AVAILABLE);
            taxi.setRider(null);
            taxi.setLocation(booking.getToLocation());

            System.out.println(booking.toString());
            System.out.println(taxi.toString());
        }

    }

    public void getAvailableTaxis() {
        for(String id : allTaxis.keySet()){
            Taxi taxi = allTaxis.get(id);
            if(taxi.getStatus()==AvailableStatus.AVAILABLE){
                System.out.println(taxi.toString());
            }
        }
    }

    public void createRider(Rider rider) {
        if (!riders.containsKey(rider.getRider_id())) {
            String formattedId = String.format("R%02d", riders.size() + 1);
            rider.setRider_id(formattedId);
            riders.put(rider.getRider_id(), rider);
//            System.out.println("Rider " + rider.getRider_id() + " added successfully");
        } else {
            System.out.println("Rider with ID " + rider.getRider_id() + " already exists");
        }
    }


    public void displayRiders() {
        for(Rider rider : riders.values()){
            System.out.println(rider.toString());
        }
    }

    public void displayAllBookings() {
        for(Booking booking : bookings.values()){
            System.out.println(booking.toString());
        }
    }
}
