package com.pluralsight.ui;

import com.pluralsight.constants.ConsoleColors;
import com.pluralsight.constants.MenuOptions;
import com.pluralsight.inventory.InventoryHandler;
import com.pluralsight.order.Order;
import com.pluralsight.products.Entree;
import com.pluralsight.products.EntreeBuilder;
import com.pluralsight.utility.InputHandler;

import static com.pluralsight.products.EntreeBuilder.featuredEntrees;

public class HomeScreen {

    private static final String comingSoonText = "Feature coming soon!";





    public static void showEntrees(){
        System.out.println("Featured Entrees");

        for (Entree entree : featuredEntrees) {
            final String menuFormat = "\t%s%d%s - %s: - Price: $%.2f\t%s";
            System.out.printf(menuFormat,ConsoleColors.BLUE_BOLD,entree.getId(),ConsoleColors.RED,entree.getDisplayName(), entree.getPrice(),ConsoleColors.RESET);
        }
    }

    public static void showMenuChoices(){
        System.out.println();
        System.out.println("\nMenu Options:");
        final String menuFormat = "\t%s%d. %s%s%s%n";

        System.out.printf(menuFormat, ConsoleColors.BLUE_BOLD, MenuOptions.customOrder,ConsoleColors.RED,MenuOptions.customOrderText, ConsoleColors.RESET);
        System.out.printf(menuFormat, ConsoleColors.BLUE_BOLD, MenuOptions.orderEntree,ConsoleColors.RED,MenuOptions.orderEntreeText, ConsoleColors.RESET);
        System.out.printf(menuFormat, ConsoleColors.BLUE_BOLD, MenuOptions.viewReceipts,ConsoleColors.RED,MenuOptions.viewReceiptsText, ConsoleColors.RESET);
        System.out.printf(menuFormat, ConsoleColors.BLUE_BOLD, MenuOptions.exit,ConsoleColors.RED,MenuOptions.exitText, ConsoleColors.RESET);
    }

    public static void userOptions(){
        System.out.println();
        int choice = InputHandler.getUserIntInput("Enter a number Option: ");

        switch(choice){
            case MenuOptions.customOrder:
                System.out.println(comingSoonText);
                break;
            case MenuOptions.orderEntree:
                System.out.println(comingSoonText);
                break;
            case MenuOptions.viewReceipts:
                System.out.println(comingSoonText);
                break;
            case MenuOptions.exit:
                InputHandler.exit();
                break;
            default:
                System.out.println(MenuOptions.invalidOptionText);
                break;
        }
        if (choice != MenuOptions.exit && choice != MenuOptions.viewReceipts && choice != MenuOptions.orderEntree && choice != MenuOptions.customOrder) {
            InputHandler.waitForEnter();
        }

    }



    public Order orderEntree(){
        return null;
    }


}
