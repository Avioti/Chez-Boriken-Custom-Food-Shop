package com.pluralsight.ui;

import com.pluralsight.order.Order;
import com.pluralsight.utility.InputHandler;

import static com.pluralsight.ui.AddItemScreen.*;


public class CheckoutScreen extends OrderScreen {

    public static void showSummary(Order order) {
        System.out.println("\nOrder Summary");
        getPlateItems();
        System.out.printf("\nTotal Price: $%.2f%n", customPlate.getPrice());

    }

    public static boolean confirmOrder() {
        if (InputHandler.getYesOrNoInput("\n Would you like to confirm your order?")) {
            System.out.println("\nOrder confirmed! Enjoy your Meal!");
            return true;
        }
        System.out.println("\nOrder not confirmed. You can modify your order.");
        return false;
    }

    public static void addAnotherOrder() {
        if (InputHandler.getYesOrNoInput("\n Would you like to place another order?")) {
            plate.clear();
            selectedMains.clear();
            selectedSides.clear();
            selectedDrinks.clear();
            WelcomeScreen.mainLoop();
        } else {
            InputHandler.exit();
        }
    }


}
