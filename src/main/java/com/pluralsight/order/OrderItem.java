package com.pluralsight.order;

import com.pluralsight.core.Orderable;

public class OrderItem {
    Orderable product;
    int quantity;


    public OrderItem(Orderable product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    public Orderable getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }




}
