package com.project;

import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OnlineShoppingSystem {
    public static OnlineShoppingSystem instance;

    private static Map<String, User> users;
    private static Map<String, Product> products;
    private static Map<String, ShoppingCart> carts;

    private OnlineShoppingSystem() {
        users = new ConcurrentHashMap<>();
        products = new ConcurrentHashMap<>();
        carts = new ConcurrentHashMap<>();
    }

    public static OnlineShoppingSystem getInstance() {
        if(instance == null){
            instance = new OnlineShoppingSystem();
        }
        return instance;
    }

    public void createUser(User user) {
        if (users.containsKey(user.getEmail())) {
            System.out.println("User with this email already exists");
            return;
        }
        user.setUserId("U"+(users.size()+1));
        users.put(user.getEmail(), user);
        System.out.println("User created");
    }

    public void displayUsers() {
        for(User user : users.values()){
            System.out.println(user.toString());
        }
    }

    public void createProduct(Product product) {
        if (products.containsKey(product.getName())) {
            System.out.println("Product with this name already exists");
            return;
        }
        product.setProductId("P"+(products.size()+1));
        products.put(product.getProductId(), product);
        System.out.println("Product created");
    }

    public void displayProducts() {
        for(Product product : products.values()){
            System.out.println(product.toString());
        }
    }

    public void createShoppingCart(String userId) {
        if(carts.containsKey(userId)){
            System.out.println("Cart for this user already exists");
            return;
        }
        ShoppingCart cart = new ShoppingCart("C" + (carts.size() + 1), userId);
        carts.put(userId, cart);
        System.out.println("Shopping cart created for user: " + userId);
    }

    public void addProductToCart(String userId, String productId, int quantity) {
        //fetch cart by using userId
        ShoppingCart cart = carts.get(userId);
        if (cart == null) {
            System.out.println("No cart found for user: " + userId);
            return;
        }
        Product product = products.get(productId);
        if (product == null) {
            System.out.println("Product not found: " + productId);
            return;
        }

        cart.addProduct(product, quantity);
        System.out.println("Product added to cart: " + productId);
    }

    public void displayCartItems(String userId) {
        ShoppingCart cart = carts.get(userId);
        if (cart == null) {
            System.out.println("No cart found for user: " + userId);
            return;
        }

        cart.displayItems();
    }
}
