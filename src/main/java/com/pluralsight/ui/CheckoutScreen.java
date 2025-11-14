package com.pluralsight.ui;

import com.pluralsight.constants.ConsoleColors;
import com.pluralsight.constants.PlateOptions;
import com.pluralsight.order.Order;
import com.pluralsight.products.Entree;
import com.pluralsight.utility.InputHandler;

import static com.pluralsight.ui.AddItemScreen.*;
import static com.pluralsight.ui.EntreeScreens.getEntreeItems;


public class CheckoutScreen extends OrderScreen {

    public static void showSummary(Order order) {
        if(order.getPlate() == null){
            System.out.println(ConsoleColors.RED + "\nNo items in the order to display summary." + ConsoleColors.RESET);
            return;
        }
        InputHandler.clearScreen();
        System.out.printf("\n\t%s%s%s%s%s%s%s%n", PlateOptions.equals, ConsoleColors.BLUE, PlateOptions.order, ConsoleColors.RED, PlateOptions.summary, ConsoleColors.RESET, PlateOptions.equals);
        if(order.getPlate() instanceof Entree entree){
            getEntreeItems();
        } else{
            getPlateItems();
        }

        System.out.printf("%s%s%s$%.2f%s\n", ConsoleColors.BLUE, "\nTotal Price: ", ConsoleColors.RED, order.getTotalPrice(), ConsoleColors.RESET);

    }

    public static boolean confirmOrder() {

        if (InputHandler.getYesOrNoInput(String.format("%s%s%s%s%s%s%s%s",ConsoleColors.BLUE,"\nWould you li",ConsoleColors.RESET,ConsoleColors.BOLD, "ke to conf",ConsoleColors.RED, "irm your order? ", ConsoleColors.RESET))) {
            InputHandler.clearScreen();
            System.out.printf("%s%s%s%s%s\n", ConsoleColors.BOLD, "\nOrder confirmed! ", ConsoleColors.BLUE, "Enjoy your Meal!", ConsoleColors.RESET);
            return true;
        }
        return false;
    }



    public static void addAnotherOrder() {
        if (InputHandler.getYesOrNoInput(String.format("%s%s%s", ConsoleColors.BLUE, "\nWould you like to place another order? ", ConsoleColors.RESET))) {
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
