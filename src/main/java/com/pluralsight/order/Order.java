package com.pluralsight.order;

import com.pluralsight.core.Orderable;
import com.pluralsight.utility.ReceiptManager;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    String id;
    LocalDateTime createdAt;
    List<OrderItem> items;
    double totalPrice;

    public Order(String id, LocalDateTime createdAt, List<OrderItem> items, double totalPrice) {
        this.id = id;
        this.createdAt = createdAt;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public void addItem(Orderable item, int quantity) {

    }
    public void removeItem(int index) {

    }

    public double calculateTotalPrice() {
        return 0;
    }

    public boolean checkout(ReceiptManager mgr) {
        return false;
    }

    public void cancel() {

    }

    public String getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String displayOrderDetails() {
        return "";
    }
}
