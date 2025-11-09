package com.pluralsight.ui;

import com.pluralsight.inventory.InventoryHandler;
import com.pluralsight.order.Order;
import com.pluralsight.products.Entree;

import java.util.List;

public class WelcomeScreen {
    List<Entree> featuredEntrees;
    InventoryHandler inventoryHandler;



    public WelcomeScreen(List<Entree> featuredEntrees, InventoryHandler inventoryHandler) {
        this.inventoryHandler = inventoryHandler;
        this.featuredEntrees = featuredEntrees;
    }

    public void show(){
        System.out.println("Welcome to the Restaurant!");
        System.out.println("Featured Entrees:");
        for (Entree entree : featuredEntrees) {
            System.out.println("- " + entree.getName() + ": " + entree.getDescription());
        }
        System.out.println("Press Enter to continue...");
    }

    public void showMenuChoices(){
        System.out.println("1. View Menu");
        System.out.println("2. Exit");
    }

    public void displayEntreeMenu(){
        System.out.println("Entree Menu:");
        for (Entree entree : featuredEntrees) {
            System.out.println("- " + entree.getName() + ": " + entree.getDescription() + " - Price: $" + entree.getBasePrice());
        }
    }


    public Order orderEntree(){
       return null;
    }

}
