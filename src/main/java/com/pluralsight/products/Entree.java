package com.pluralsight.products;

import com.pluralsight.core.Orderable;
import com.pluralsight.inventory.Food;
import com.pluralsight.inventory.InventoryHandler;

import java.util.HashMap;

public class Entree implements Orderable {
    String name,description;
    int id;
    Food main,side,drink;
    double basePrice;

    public Entree(int id, String name, Food main,Food side,Food drink, double basePrice , String description) {
        this.id = id;
        this.name = name;
        this.main = main;
        this.side = side;
        this.drink = drink;
        this.basePrice = basePrice;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public Food getMain() {
        return main;
    }

    public Food getSide() {
        return side;
    }

    public Food getDrink() {
        return drink;
    }


    public String getDescription() {
        return description;
    }


    @Override
    public double getPrice() {
        return main.getBasePrice() + side.getBasePrice() + drink.getBasePrice();
    }

    @Override
    public String getDisplayName() {
        return name;
    }


    public String display(){
        return name;
    }
}
