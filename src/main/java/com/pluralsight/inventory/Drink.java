package com.pluralsight.inventory;

public class Drink extends Food {
    int ounces;

    public Drink(int quantity, String category, String itemName, String description, double basePrice, int ounces) {
        super(quantity, category, itemName, description, basePrice);
        this.ounces = ounces;
    }


    public int getOunces() {
        return ounces;
    }

    public void setOunces(int ounces) {
        this.ounces = ounces;
    }

    @Override
    public double getBasePrice() {
        return super.getBasePrice();
    }

    @Override
    public boolean isAvailable() {
        return super.isAvailable();
    }

    @Override
    public void reduceQuantity(int amount) {
        super.reduceQuantity(amount);
    }

    @Override
    public void increaseQuantity(int amount) {
        super.increaseQuantity(amount);
    }
}
