package com.LLD.Restaurant;

public class RestaurantReservationSystem {

    private final static RestaurantReservationSystem instance =new RestaurantReservationSystem();

    public static RestaurantReservationSystem getInstance(){
        return instance;
    }

}
