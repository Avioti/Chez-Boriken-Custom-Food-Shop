package com.pluralsight.inventory;

public class Main extends Food {


    public Main(int quantity, String category, String itemName, String description, double basePrice) {
        super(quantity, category, itemName, description, basePrice);
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
