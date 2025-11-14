package com.pluralsight.ui;

import com.pluralsight.constants.ConsoleColors;
import com.pluralsight.constants.PlateOptions;
import com.pluralsight.inventory.Food;
import com.pluralsight.inventory.InventoryHandler;
import com.pluralsight.order.Order;
import com.pluralsight.products.Entree;
import com.pluralsight.utility.InputHandler;
import com.pluralsight.utility.ReceiptManager;

import java.time.ZonedDateTime;

import static com.pluralsight.products.EntreeBuilder.featuredEntrees;
import static com.pluralsight.ui.OrderScreen.*;
import static com.pluralsight.utility.InputHandler.waitForEnterEntree;

public class EntreeScreens {
    public static Order currentEntreeOrder;
    private static Entree entree;
    private static boolean active = true;

 public static void initializeEntreeScreen() {
     while(active){
         InputHandler.clearScreen();
         WelcomeScreen.showTitle();
         showEntrees();
         entreeMenu();
         entreeUserOptions();
     }

    }


    public static void entreeMenu() {
        InputHandler.emptyLine();
        System.out.println("\nEntree Options");
        final String menuFormat = "\n\t%s%d. %s%s%s%n";

        System.out.printf(menuFormat, ConsoleColors.BLUE_BOLD, PlateOptions.orderEntree, ConsoleColors.RED, PlateOptions.orderEntreeText, ConsoleColors.RESET);
        System.out.printf(menuFormat, ConsoleColors.BLUE_BOLD, PlateOptions.editEntree, ConsoleColors.RED, PlateOptions.editEntreeText, ConsoleColors.RESET);
        System.out.printf(menuFormat, ConsoleColors.BLUE_BOLD, PlateOptions.changeSize, ConsoleColors.RED, PlateOptions.changeSizeText, ConsoleColors.RESET);
        System.out.printf(menuFormat, ConsoleColors.BLUE_BOLD, PlateOptions.checkOut, ConsoleColors.RED, PlateOptions.checkOutText, ConsoleColors.RESET);
        System.out.printf(menuFormat, ConsoleColors.BLUE_BOLD, PlateOptions.cancelOrder, ConsoleColors.RED, PlateOptions.cancelOrderText, ConsoleColors.RESET);
    }

    public static void showEntrees() {
        System.out.printf("%s%s%s",ConsoleColors.BLUE,"\nFeatured Entrees\n",ConsoleColors.RESET);
        InputHandler.emptyLine();
        for (Entree entree : featuredEntrees) {
            final String menuFormat = "\t%s%d%s - %s: - Price: $%.2f\t%s";

            System.out.printf(menuFormat, ConsoleColors.BLUE_BOLD, entree.getId(), ConsoleColors.RED, entree.getDisplayName(), entree.getPrice(), ConsoleColors.RESET);
        }
    }


    public static void orderEntree(int id) {
        if(id < 0 || id >= featuredEntrees.size()) {
            System.out.printf("%s%s%s\n", ConsoleColors.RED_BOLD, PlateOptions.invalidOption, ConsoleColors.RESET);
            return;
        }
        entree = featuredEntrees.get(id);
        currentEntreeOrder = new Order(randomId(), ZonedDateTime.now(), entree, entree.getPrice());
        InventoryHandler.reduceStockBulk(entree, 1);
        System.out.println("\n"+ConsoleColors.GREEN_BOLD+"Entree added to your order!"+ConsoleColors.RESET);
        waitForEnterEntree();
    }

    public static void editEntree() {
        System.out.println("Edit entree Main");
        System.out.println("What would you like to edit?");
        System.out.println("1. Change Main");
        System.out.println("2. Change Side");
        System.out.println("3. Change Drink");
        System.out.println("4. Change Size");
        System.out.println("0. Return to Entree Menu");
        int choice = InputHandler.getUserIntInput("Enter your choice: ");
        switch (choice) {
            case 1:
                changeEntreeMain();
                break;
            case 2:
                changeEntreeSide();
                break;
            case 3:
                changeEntreeDrink();
                break;
            case PlateOptions.changeSize:
                showSizeMenu();
                break;
            case 0:
                return;
            default:
                System.out.printf("%s%s%s\n", ConsoleColors.RED_BOLD, PlateOptions.invalidOption, ConsoleColors.RESET);
                break;
        }
    }

    public static void changeEntreeMain(){
        System.out.println("Change Entree Main?" + entree.getMain());
        System.out.println("Select a new Main:");
        InventoryHandler.getItemsByCategory("main");
        Food food = AddItemScreen.promptSelectMain();
        System.out.println("Item updated with " + food.getItemName());
        entree.setMain(food);
        InventoryHandler.reduceStock(food,1);
        waitForEnterEntree();


    }

    public static void changeEntreeSide(){
        System.out.println("Change Entree Side?" + entree.getSide());
        System.out.println("Select a new Side:");
        InventoryHandler.getItemsByCategory("side");
        Food food = AddItemScreen.promptSelectSide();
        System.out.println("Item updated with " + food.getItemName());
        entree.setSide(food);
        InventoryHandler.reduceStock(food,1);
        waitForEnterEntree();


    }


    public static void changeEntreeDrink(){
        System.out.println("Change Entree Drink?" + entree.getDrink());
        System.out.println("Select a new Drink:");
        InventoryHandler.getItemsByCategory("drink");
        Food food = AddItemScreen.promptSelectDrink();
        System.out.println("Item updated with " + food.getItemName());
        entree.setDrink(food);
        InventoryHandler.reduceStock(food,1);
        waitForEnterEntree();


    }

    public static void getEntreeItems(){
        System.out.printf("%s%s%s\n", ConsoleColors.BOLD, PlateOptions.currentEntreeItems, ConsoleColors.RESET);
        System.out.printf("\n\t%s-%s %s%s\n", ConsoleColors.BLUE, ConsoleColors.RED, entree.getMain().getItemName(), ConsoleColors.RESET);
        System.out.printf("\n\t%s-%s %s%s\n", ConsoleColors.BLUE, ConsoleColors.RED, entree.getSide().getItemName(), ConsoleColors.RESET);
        System.out.printf("\n\t%s-%s %s%s\n", ConsoleColors.BLUE, ConsoleColors.RED, entree.getDrink().getItemName(), ConsoleColors.RESET);
    }

    private static void checkOutEntree() {
        CheckoutScreen.showSummary(currentEntreeOrder);
        System.out.printf("\t%s%s%s\n", ConsoleColors.BLUE_BOLD, PlateOptions.proceedingToCheckout, ConsoleColors.RESET);
        if (CheckoutScreen.confirmOrder()) {
            System.out.println(ReceiptManager.createReceipt(currentEntreeOrder));
            CheckoutScreen.addAnotherOrder();
        } else {
            cancelOrder();
        }
    }


    public static void entreeUserOptions() {
        InputHandler.emptyLine();
        int choice = InputHandler.getUserIntInput(PlateOptions.enterNumberOption);

        switch (choice) {
            case PlateOptions.orderEntree:
                orderEntree(InputHandler.getUserIntInput("Choose Entree by ID: ") - 1);
                break;
              case PlateOptions.editEntree:
                editEntree();
                break;
            case PlateOptions.checkOut:
                checkOutEntree();
                break;
            case PlateOptions.cancelOrder:
                cancelOrder();
                active = false;
                break;
            default:
                System.out.printf("%s%s%s\n", ConsoleColors.RED_BOLD, PlateOptions.invalidOption, ConsoleColors.RESET);
                break;
        }


    }
}
