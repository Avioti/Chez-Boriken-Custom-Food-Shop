package com.pluralsight.order;

import com.pluralsight.core.Orderable;
import com.pluralsight.products.CustomPlate;
import com.pluralsight.products.Entree;
import com.pluralsight.utility.ReceiptManager;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

public class Order {
    String id;
    ZonedDateTime createdAt;
    double totalPrice;
    CustomPlate customPlate;
    Entree entree;

    public Order(String id, ZonedDateTime createdAt, CustomPlate customPlate, double totalPrice) {
        this.id = id;
        this.createdAt = createdAt;
        this.customPlate = customPlate;
        this.totalPrice = totalPrice;
    }

    public Order(String id, ZonedDateTime createdAt, Entree entree, double totalPrice) {
        this.id = id;
        this.createdAt = createdAt;
        this.entree = entree;
        this.totalPrice = totalPrice;
    }



    public String getId() {
        return id;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public CustomPlate getCustomPlate() {
        return customPlate;
    }

    public Entree getEntree() {
        return entree;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", totalPrice=" + totalPrice +
                ", customPlate=" + customPlate +
                ", entree=" + entree +
                '}';
    }


}
