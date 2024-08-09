import com.LLD.Guest;
import com.LLD.Payment.CreditCard;
import com.LLD.Payment.Payment;
import com.LLD.Reservation.Reservation;
import com.LLD.Room.AvailabilityStatus;
import com.LLD.Room.Room;
import com.LLD.Room.RoomType;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Initialize the Scanner

        HotelReservationSystem hotelReservationSystem = HotelReservationSystem.getInstance();
        Guest guest1 = new Guest("G01", "Hariram", "hariramb01@gmail.com", "6383561252");
        Guest guest2 = new Guest("G02", "Harish", "bhariram01@gmail.com", "638361253");

        Room room1 = new Room("R01", RoomType.SINGLE, 1300.00);
        Room room2 = new Room("R02", RoomType.QUEEN, 5799.00);

        hotelReservationSystem.addRoom(room1);
        hotelReservationSystem.addRoom(room2);

        hotelReservationSystem.addGuest(guest1);
        hotelReservationSystem.addGuest(guest2);

        boolean exit = false;
        Reservation currentReservation = null; // Track the current reservation

        while (!exit) {
            // Display the menu options
            System.out.println("1. Book Reservation");
            System.out.println("2. Cancel Reservation");
            System.out.println("3. Check-In");
            System.out.println("4. Check-Out");
            System.out.println("5. Display");
            System.out.println("6. Exit");

            // Read the user's choice
            int value;
            try {
                value = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // Clear the invalid input
                continue;
            }

            // Handle the user's choice using a switch statement
            switch (value) {
                case 1:
                    LocalDate checkInDate = LocalDate.now();
                    LocalDate checkOutDate = LocalDate.now().plusDays(3);
                    currentReservation = hotelReservationSystem.bookRoom(guest1, room1, checkInDate, checkOutDate);

                    if (currentReservation != null) {
                        System.out.println("Reservation created: " + currentReservation.getId());
                    } else {
                        System.out.println("Room not available for booking.");
                    }
                    break;

                case 2:
                    if (currentReservation != null) {
                        hotelReservationSystem.cancelReservation(currentReservation.getId());
                        System.out.println("Reservation canceled: " + currentReservation.getId());
                        currentReservation = null; // Clear the current reservation
                    } else {
                        System.out.println("No reservation to cancel.");
                    }
                    break;

                case 3:
                    if (currentReservation != null) {
                        hotelReservationSystem.checkInToHotel(currentReservation.getId());
                        System.out.println("Checked in: " + currentReservation.getId());
                    } else {
                        System.out.println("No reservation to check in.");
                    }
                    break;

                case 4:
                    if (currentReservation != null && currentReservation.getRoom().getStatus()==AvailabilityStatus.OCCUPIED) {
                        Payment payment = new CreditCard();
                        hotelReservationSystem.checkOutFromHotel(currentReservation.getId(), payment);
                        System.out.println("Checked out: " + currentReservation.getId());
                        currentReservation = null; // Clear the current reservation
                    }
                    else if(currentReservation!=null && currentReservation.getRoom().getStatus()==AvailabilityStatus.BOOKED){
                        System.out.println("This user "+currentReservation.getId()+" hasn't checked In yet");
                    }
                    else {
                        System.out.println("No reservation to check out.");
                    }
                    break;

                case 5:
                    // display all the details
                    hotelReservationSystem.display();
                    break;

                case 6:
                    // Exit the application
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    // Handle invalid input
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        sc.close(); // Close the scanner
    }
}
