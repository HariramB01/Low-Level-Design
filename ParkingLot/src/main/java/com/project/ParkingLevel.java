package com.project;

import java.util.Map;

public class ParkingLevel {

    private String floor_id ;
    private int noOfSpots;

    public ParkingLevel() {

    }

    public ParkingLevel(String floor_id, int noOfSpots) {
        this.floor_id = floor_id;
        this.noOfSpots = noOfSpots;
    }

    public String getFloor_id() {
        return floor_id;
    }

    public int getNoOfSpots() {
        return noOfSpots;
    }

}
