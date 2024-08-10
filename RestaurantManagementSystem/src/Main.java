import com.LLD.Restaurant.*;

import java.sql.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner sc = new Scanner(System.in);
        RestaurantReservationSystem reservationSystem = RestaurantReservationSystem.getInstance();

        MenuItem menu1 = new MenuItem("M01", "Chicken Biryani", "Hyderabad spicy biryani", 180.50, true);
        MenuItem menu2 = new MenuItem("M02", "Paneer Butter Masala", "Delicious paneer with butter masala", 150.00, true);
        MenuItem menu3 = new MenuItem("M03", "Veg Fried Rice", "Vegetable fried rice with soy sauce", 120.00, true);


        Staff staff1 = new Staff("S01", "John Doe", "Chef", "123-456-7890");
        Staff staff2 = new Staff("S02", "Jane Doe", "Waiter", "098-765-4321");
        Staff staff3 = new Staff("S03", "Mike Smith", "Manager", "111-222-3333");

        Customer customer1 = new Customer("C01", "James", "6383561252", "bhariram01@gmail.com");
        Customer customer2 = new Customer("C02", "Johnny", "6383561253", "hariramb01@gmail.com");
        Customer customer3 = new Customer("C03", "Michael", "6383561254", "harish0701@gmail.com");

//        Reservation reservation1 = new Reservation("R01", "Alice", "alice@example.com", 2, new Timestamp(System.currentTimeMillis()));
//        Reservation reservation2 = new Reservation("R02", "Bob", "bob@example.com", 4, new Timestamp(System.currentTimeMillis()));
//        Reservation reservation3 = new Reservation("R03", "Charlie", "charlie@example.com", 3, new Timestamp(System.currentTimeMillis()));

        reservationSystem.addItem(menu1);
        reservationSystem.addItem(menu2);
        reservationSystem.addItem(menu3);

        reservationSystem.addStaff(staff1);
        reservationSystem.addStaff(staff2);
        reservationSystem.addStaff(staff3);

        reservationSystem.addCustomers(customer1);
        reservationSystem.addCustomers(customer2);
        reservationSystem.addCustomers(customer3);

//        reservationSystem.addReservation(reservation1);
//        reservationSystem.addReservation(reservation2);
//        reservationSystem.addReservation(reservation3);

//        OrderItem order1 = new OrderItem("Order1", OrderStatus.PENDING,
//                Arrays.asList(menu1,menu2,menu3) ,new Timestamp(System.currentTimeMillis()));
//
//        OrderItem order2 = new OrderItem("Order2", OrderStatus.PENDING,
//                Arrays.asList(menu1), new Timestamp(System.currentTimeMillis()));



        boolean exit = false;
        while(!exit){
            System.out.println("1. display MenuItem");
            System.out.println("2. Display Staffs");
            System.out.println("3. Display Reservation");
            System.out.println("4. Reserve your table");
            System.out.println("5. Place an Order");
            System.out.println("6. Update Order Status");
            System.out.println("7. Display Customers");

            int value = sc.nextInt();

            switch (value){
                case 1:
                    reservationSystem.displayItems();
                    break;
                case 2:
                    reservationSystem.displayStaff();
                    break;
                case 3:
                    reservationSystem.displayReservation();
                    break;
                case 4:
                    reservationSystem.displayPayments();
                    reservationSystem.displayOrders();
                    break;
                case 5:
                    System.out.println("Enter the reservation Id: ");
                    String reservationId = sc.nextLine();
                    if(reservationSystem.isAvailable(reservationId)) {


                        OrderItem order = new OrderItem();
                        sc.nextLine(); // Consume newline left-over
                        System.out.println("Enter the order Id :");
                        order.setId(sc.nextLine());
                        System.out.println("Enter the Customer Id :");
                        order.setCustomerId(sc.nextLine());
                        order.setStatus(OrderStatus.PENDING);

                        List<MenuItem> items = new ArrayList<>();
                        boolean addMoreItems = true;
                        while (addMoreItems) {
                            System.out.println("Enter MenuItem ID (or type 'done' to finish):");
                            String menuItemId = sc.nextLine();

                            if ("done".equalsIgnoreCase(menuItemId)) {
                                addMoreItems = false;
                            } else {
                                MenuItem menuItem = reservationSystem.getItemById(menuItemId);
                                if (menuItem != null) {
                                    items.add(menuItem);
                                } else {
                                    System.out.println("Invalid MenuItem ID. Please try again.");
                                }
                            }
                        }

                        order.setItems(items);
                        reservationSystem.placeOrder(order);
                    }
                    else{
                        System.out.println("You didn't reserve any table here!!!");
                    }
                    break;

                case 6:
                    reservationSystem.updateOrderStatus("Order1",OrderStatus.PREPARING);
                    reservationSystem.displayOrders();
                    reservationSystem.updateOrderStatus("Order1",OrderStatus.COMPLETED);
                    reservationSystem.displayOrders();
                    reservationSystem.updateOrderStatus("Order1",OrderStatus.READY);
                    reservationSystem.displayOrders();
                    break;
                case 7:
                    reservationSystem.displayCustomer();
                    break;
                default:
                    System.out.println("No such case here");
                    exit = true;
                    break;
            }
        }
        sc.close();
    }
}
