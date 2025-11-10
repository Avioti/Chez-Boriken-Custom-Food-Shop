package com.pluralsight.ui;

import com.pluralsight.constants.ConsoleColors;
import com.pluralsight.constants.PlateOptions;
import com.pluralsight.constants.Size;
import com.pluralsight.inventory.InventoryHandler;
import com.pluralsight.order.Order;
import com.pluralsight.utility.InputHandler;

import static com.pluralsight.ui.HomeScreen.comingSoon;

public class OrderScreen {
    private Order currentOrder;
    private static Size size;

    public static void show(){
        InputHandler.clearScreen();
        WelcomeScreen.showTitle();

        System.out.printf("\n\t%s%s%s%s%s%s%s%s%s\n", PlateOptions.equals,ConsoleColors.BLUE, PlateOptions.customPl, ConsoleColors.RESET,PlateOptions.a,ConsoleColors.RED,PlateOptions.teMenu,ConsoleColors.RESET,PlateOptions.equals);

        System.out.printf("\nWhat size plate would you like? (Allowed Portions)\n\n\t%s%d - %s%s %s%s\n\t%s%d - %s%s %s%s\n\t%s%d - %s%s %s%s%s\n",
                ConsoleColors.BLUE_BOLD,PlateOptions.sizeSmall,ConsoleColors.RED,PlateOptions.sizeSmallText,ConsoleColors.BLUE,PlateOptions.smallSizes,
                ConsoleColors.BLUE_BOLD,PlateOptions.sizeMedium,ConsoleColors.RED,PlateOptions.sizeMediumText,ConsoleColors.BLUE,PlateOptions.mediumSizes,
                ConsoleColors.BLUE_BOLD,PlateOptions.sizeLarge,ConsoleColors.RED,PlateOptions.sizeLargeText,ConsoleColors.BLUE,PlateOptions.largeSizes,ConsoleColors.RESET);

        size = InputHandler.getSizeInput("\nEnter Desired Size: ");

        System.out.println("\nWhat would you like today?");
        final String menuFormat = "\n%s%d. - %s%s\n%s%d. - %s%s\n%s%d. - %s%s%n%s";
        System.out.printf(menuFormat, ConsoleColors.BLUE,PlateOptions.addMain,ConsoleColors.RED,PlateOptions.addMainText,
                ConsoleColors.BLUE,PlateOptions.addSide,ConsoleColors.RED,PlateOptions.addSideText,
                ConsoleColors.BLUE,PlateOptions.addDrink,ConsoleColors.RED,PlateOptions.addDrinkText,ConsoleColors.RESET);

        userOptions();

    }
    public void addMain(){

    }

    public void addSide(){

    }

    public void addDrink(){

    }

    public void checkOut(){

    }

    public void cancelOrder(){

    }

    private static void userOptions(){
        System.out.println();
        int choice = InputHandler.getUserIntInput("Enter a number Option: ");

        switch(choice){
            case PlateOptions.addMain:
               comingSoon();
                break;
            case PlateOptions.addSide:
                comingSoon();
                break;
            case PlateOptions.addDrink:
                comingSoon();
                break;
            case PlateOptions.checkOut:
                comingSoon();
                break;
            case PlateOptions.cancelOrder:
                comingSoon();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }

    }

}
