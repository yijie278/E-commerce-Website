package org.example.project;

import java.util.List;
import java.util.Date;

public class Order {
    private String id;
    private List<CartItem> items;
    private double total;
    private Date orderDate;

    public Order(String id, List<CartItem> items, double total) {
        this.id = id;
        this.items = items;
        this.total = total;
        this.orderDate = new Date();
    }

    // Getters
    public String getId() { return id; }
    public List<CartItem> getItems() { return items; }
    public double getTotal() { return total; }
    public Date getOrderDate() { return orderDate; }
}