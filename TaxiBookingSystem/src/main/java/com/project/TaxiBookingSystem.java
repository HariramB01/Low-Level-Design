package com.project;

public class TaxiBookingSystem {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        TaxiHub taxi = TaxiHub.getInstance();

        taxi.createTaxis(new Taxi("T01","TN-25-RH-0701","Harish", 130.00));
        taxi.createTaxis(new Taxi("T01","TN-25-RH-0702","Harish", 130.00));
        taxi.createTaxis(new Taxi("T02","TN-25-RH-0701","Harish", 130.00));
        taxi.createTaxis(new Taxi("T03","TN-25-RH-0701","Harish", 130.00));
        taxi.createTaxis(new Taxi("T04","TN-25-RH-0701","Harish", 130.00));

        taxi.createRider(new Rider
                ("Hariram","6383561252","bhariram01@gmail.com"));
        taxi.createRider(new Rider
                ("Harish","6383561252","bhariram01@gmail.com"));
        taxi.createRider(new Rider
                ("Hariram","6383561252","bhariram01@gmail.com"));
        taxi.createRider(new Rider
                ("Hariram","6383561252","bhariram01@gmail.com"));

        taxi.displayRiders();



        taxi.bookTaxi("T01","R01",'A','C');


        System.out.println("-----------------------------------");
        taxi.releaseTaxi("BR0101");

        System.out.println("-----------------------------------");
        taxi.displayAllTaxis();
        System.out.println("-----------------------------------");
        taxi.displayAllBookings();
    }
}