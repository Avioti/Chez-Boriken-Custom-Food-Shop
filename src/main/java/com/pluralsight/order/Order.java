package com.pluralsight.order;


import com.pluralsight.products.Entree;

import java.time.ZonedDateTime;


public class Order<T> {
    String id;
    ZonedDateTime createdAt;
    double totalPrice;
    T plate;
    Entree entree;

    public Order(String id, ZonedDateTime createdAt, T plate, double totalPrice) {
        this.id = id;
        this.createdAt = createdAt;
        this.plate = plate;
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

    public T getPlate() {
        return plate;
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
                ", plate=" + plate +
                ", entree=" + entree +
                '}';
    }


}
