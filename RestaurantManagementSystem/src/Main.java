import com.LLD.Restaurant.RestaurantReservationSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner sc = new Scanner(System.in);
        RestaurantReservationSystem reservationSystem = RestaurantReservationSystem.getInstance();

        boolean exit = false;
        while(!exit){
            System.out.println("1. display MenuItem");
            System.out.println("2. Display Orders");
            System.out.println("3. Display Reservation");
            System.out.println("4. Display Payments");
            System.out.println("5. Display Staffs");

            int value = sc.nextInt();

            switch (value){
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("No such case here");
                    exit = true;
                    break;
            }
            sc.close();
        }
    }
}