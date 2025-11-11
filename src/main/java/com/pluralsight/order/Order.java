package com.pluralsight.order;

import com.pluralsight.core.Orderable;
import com.pluralsight.products.CustomPlate;
import com.pluralsight.products.Entree;
import com.pluralsight.utility.ReceiptManager;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    String id;
    LocalDateTime createdAt;
    List<OrderItem> items;
    double totalPrice;
    CustomPlate customPlate;
    Entree entree;

    public Order(String id, LocalDateTime createdAt, CustomPlate customPlate, double totalPrice) {
        this.id = id;
        this.createdAt = createdAt;
        this.customPlate = customPlate;
        this.totalPrice = totalPrice;
    }

    public Order(String id, LocalDateTime createdAt, Entree entree, double totalPrice) {
        this.id = id;
        this.createdAt = createdAt;
        this.entree = entree;
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
