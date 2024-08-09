package com.LLD.Reservation;

import com.LLD.Guest;
import com.LLD.Room.AvailabilityStatus;
import com.LLD.Room.Room;

import java.time.LocalDate;

public class Reservation {
    private String id;
    private Room room;
    private Guest guest;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private ReservationStatus status;

    public Reservation() {
    }

    public Reservation(String id, Room room, Guest guest, LocalDate checkIn, LocalDate checkOut) {
        this.id = id;
        this.room = room;
        this.guest = guest;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.status = ReservationStatus.CONFIRMED;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public synchronized void cancel() {
        if(status == ReservationStatus.CONFIRMED) {
            status = ReservationStatus.CANCELLED;

            // Change room status to AVAILABLE without calling checkOut()
            if (room.getStatus() == AvailabilityStatus.BOOKED) {
                room.setStatus(AvailabilityStatus.AVAILABLE);
            } else {
                System.out.println("Room is not booked");
            }
        } else {
            System.out.println("Room is not confirmed");
        }
    }


    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", room=" + room +
                ", guest=" + guest +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", status=" + status +
                '}';
    }
}
