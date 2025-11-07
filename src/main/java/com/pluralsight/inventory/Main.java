package com.pluralsight.inventory;

public class Main extends Food {
    String primaryMain;

    public Main(double basePrice, String category, String itemName, int quantity, String primaryMain) {
        super(basePrice, category, itemName, quantity);
        this.primaryMain = primaryMain;

    }


}
