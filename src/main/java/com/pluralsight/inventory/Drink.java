package com.pluralsight.inventory;

public class Drink extends Food {
    int ounces;

    public Drink(double basePrice, String category, String itemName, int quantity, int ounces) {
        super(basePrice, category, itemName, quantity);
        this.ounces = ounces;
    }

    public int getOunces() {
        return ounces;
    }

    public void setOunces(int ounces) {
        this.ounces = ounces;
    }
}
