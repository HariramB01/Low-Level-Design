package com.LLD.Room;

public class Room {
    private String id;
    private RoomType type;
    private AvailabilityStatus status;
    private double price;

    public Room() {
    }

    public Room(String id, RoomType type, double price) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.status = AvailabilityStatus.AVAILABLE;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public AvailabilityStatus getStatus() {
        return status;
    }

    public void setStatus(AvailabilityStatus status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void book() {
        if(status==AvailabilityStatus.AVAILABLE){
            status = AvailabilityStatus.BOOKED;
        }
        else{
            System.out.println("Room is not available for booking");
        }
    }

    public synchronized void checkIn() {
        if(status==AvailabilityStatus.BOOKED){
            status = AvailabilityStatus.OCCUPIED;
        }
        else{
            System.out.println("Room is not booked");
        }
    }

//    public synchronized void checkOut() {
//        if(status==AvailabilityStatus.OCCUPIED){
//            status=AvailabilityStatus.AVAILABLE;
//        }
//        else{
//            throw new IllegalStateException("Room is not occupied");
//        }
//    }


    public synchronized void checkOut() {
        if(status == AvailabilityStatus.OCCUPIED) {
            status = AvailabilityStatus.AVAILABLE;
        }
        else {
            System.out.println("Room is not occupied");
        }
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", price=" + price +
                '}';
    }
}
