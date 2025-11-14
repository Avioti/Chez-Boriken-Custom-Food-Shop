package com.pluralsight.products;

import com.pluralsight.constants.Size;
import com.pluralsight.core.Orderable;
import com.pluralsight.inventory.Food;


public class Entree implements Orderable {
    String name,description;
    int id;
    Food main,side,drink;
    double basePrice;
    Size size;

    public Entree(int id, String name, Food main, Food side, Food drink, double basePrice , String description, Size size) {
        this.id = id;
        this.name = name;
        this.main = main;
        this.side = side;
        this.drink = drink;
        this.basePrice = basePrice;
        this.description = description;
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getName() {
        return name;
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


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMain(Food main) {
        this.main = main;
    }

    public void setSide(Food side) {
        this.side = side;
    }

    public void setDrink(Food drink) {
        this.drink = drink;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
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

    @Override
    public String toString() {
        return String.format("%d|%s|%s|%s|%.2f", id, main , side ,drink , getPrice());
    }
}
