package com.pluralsight.inventory;

public abstract class Food {
    int quantity;
    public String itemName;
    String category;
    double basePrice;

    public Food(double basePrice, String category, String itemName, int quantity) {
        this.basePrice = basePrice;
        this.category = category;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public boolean isAvailable(){
        return quantity>0;
    }

    public double getBasePrice(){
        return basePrice;
    }

    public void reduceQuantity(int amount){
        quantity-=amount;
    }

    public void increaseQuantity(int amount){
        quantity+=amount;
    }
}
