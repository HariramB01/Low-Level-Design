import com.LLD.Guest;
import com.LLD.Payment.Payment;
import com.LLD.Reservation.Reservation;
import com.LLD.Reservation.ReservationStatus;
import com.LLD.Room.AvailabilityStatus;
import com.LLD.Room.Room;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HotelReservationSystem {

    private final static HotelReservationSystem instance = new HotelReservationSystem();

    private final Map<String, Room> rooms;
    private final Map<String, Guest> guests;
    private final Map<String, Reservation> reservations;


    private HotelReservationSystem(){
        rooms = new ConcurrentHashMap<>();
        guests = new ConcurrentHashMap<>();
        reservations = new ConcurrentHashMap<>();
    }

    public static HotelReservationSystem getInstance(){
        return instance;
    }


    public void display(){
        for(Room room : rooms.values()){
            System.out.println(room.toString());
        }
        System.out.println("--------------------------");
        for(Guest guest : guests.values()){
            System.out.println(guest.toString());
        }
        System.out.println("--------------------------");
        for(Reservation reservation : reservations.values()){
            System.out.println(reservation.toString());
        }
    }

    public void addRoom(Room room) {
        rooms.put(room.getId(),room);
    }

    public void addGuest(Guest guest) {
        guests.put(guest.getId(),guest);
    }

    public synchronized Reservation bookRoom(Guest guest1, Room room1, LocalDate checkInDate, LocalDate checkOutDate) {
        if(room1.getStatus()==AvailabilityStatus.AVAILABLE){
            room1.book();
            String reservationId = generateReservationId();
            Reservation reservation =new Reservation(reservationId, room1, guest1,checkInDate, checkOutDate);
            reservations.put(reservationId, reservation);
            return reservation;
        }
        return null;
    }



    private String generateReservationId() {
        return "Res"+ UUID.randomUUID().toString().substring(0,5).toUpperCase();
    }

    public synchronized void checkInToHotel(String id) {
        Reservation reservation = reservations.get(id);
        if(reservation!=null && reservation.getStatus()== ReservationStatus.CONFIRMED){
            reservation.getRoom().checkIn();
        }
        else{
            System.out.println("Invalid reservation or reservation not confirmed");
        }
    }

    public synchronized void checkOutFromHotel(String id, Payment payment) {
        Reservation reservation = reservations.get(id);
        if(reservation!=null && reservation.getStatus()== ReservationStatus.CONFIRMED){
            Room room = reservation.getRoom();
            double amount = room.getPrice() * ChronoUnit.DAYS.between(reservation.getCheckIn(),reservation.getCheckOut());
            if(payment.processPayment(amount)){
                room.checkOut();
                reservations.remove(reservation.getId());
                System.out.println("Payment Successful");
            }
            else{
                System.out.println("OOps! error on payment");
            }
        }else{
            System.out.println("Invalid reservation or reservation not confirmed");
        }
    }

    public synchronized void cancelReservation(String id) {
        Reservation reservation = reservations.get(id);
        if(reservation!=null && reservation.getStatus()==ReservationStatus.CONFIRMED){
            reservation.cancel();
            reservations.remove(id);
        }
        else{
            System.out.println("THere is no reservation available on this id "+reservation.getId());
        }
    }
}
