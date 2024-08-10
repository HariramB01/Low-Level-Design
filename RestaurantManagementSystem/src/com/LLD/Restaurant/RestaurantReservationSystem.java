package com.LLD.Restaurant;

import com.LLD.Payment.Payment;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class RestaurantReservationSystem {

    private final static RestaurantReservationSystem instance =new RestaurantReservationSystem();
    private final List<MenuItem> items;
    private final List<Staff> staffs;
    private final List<Customer> customers;
    private final List<Reservation> reservations;
    private final Map<String, OrderItem> orders;
    private final Map<String, Payment> payments;

    public RestaurantReservationSystem(){
        items = new CopyOnWriteArrayList<>();
        staffs = new CopyOnWriteArrayList<>();
        reservations = new CopyOnWriteArrayList<>();
        customers = new CopyOnWriteArrayList<>();
        orders = new ConcurrentHashMap<>();
        payments = new ConcurrentHashMap<>();
    }


    public static RestaurantReservationSystem getInstance(){
        return instance;
    }


    public void addItem(MenuItem menu) {
        items.add(menu);
    }

    public void addStaff(Staff staff) {
        staffs.add(staff);
    }

    public void addCustomers(Customer customer) {
        customers.add(customer);
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void displayItems() {
        for(MenuItem item : items){
            System.out.println(item);
        }
        System.out.println("-------------------------");
    }

    public void displayStaff() {
        for(Staff staff : staffs){
            System.out.println(staff);
        }
        System.out.println("------------------------");
    }

    public void displayCustomer() {
        for(Customer customer : customers){
            System.out.println(customer);
        }
        System.out.println("------------------------");
    }

    public void displayReservation() {
        for(Reservation reservation : reservations){
            System.out.println(reservation);
        }
        System.out.println("------------------------------");

    }

    public void displayPayments() {
        for(Payment payment : payments.values()){
            System.out.println(payment.toString());
        }
    }

    public void displayOrders() {
        for(OrderItem order : orders.values()){
            System.out.println(order.toString());
        }
    }

    public void placeOrder(OrderItem order) {
        OrderItem orderedItem = new OrderItem(order.getId(), order.getCustomerId(), order.getStatus(), order.getItems(), new Timestamp(System.currentTimeMillis()));
        orders.put(order.getId(), order);
        displayOrders();
    }

    public void updateOrderStatus(String id, OrderStatus status) {
        OrderItem order = orders.get(id);
        if(order!=null){
            order.setStatus(status);
            displayOrders();
        }
        else{
            System.out.println("order hasn't placed yet");
        }
    }

    public void cancelReservation(Reservation reservation1) {
        reservations.remove(reservation1);
        displayOrders();
    }

    public MenuItem getItemById(String id) {
        for (MenuItem item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null; // If no item matches the given id
    }

    public boolean isAvailable(String reservationId) {
        return reservations.contains(reservationId);
    }
}
