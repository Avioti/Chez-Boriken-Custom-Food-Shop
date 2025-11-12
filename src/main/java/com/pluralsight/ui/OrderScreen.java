package com.pluralsight.ui;

import com.pluralsight.constants.ConsoleColors;
import com.pluralsight.constants.PlateOptions;
import com.pluralsight.constants.Size;
import com.pluralsight.inventory.Food;
import com.pluralsight.order.Order;
import com.pluralsight.products.CustomPlate;
import com.pluralsight.utility.InputHandler;
import com.pluralsight.utility.ReceiptManager;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.pluralsight.products.CustomPlate.*;
import static com.pluralsight.ui.AddItemScreen.*;

public class OrderScreen {
    private static Order currentOrder;
    protected static Size size;
    static protected ArrayList<Food> plate = new ArrayList<>();
    private static String customerName;
    private static boolean pineappleBowl;
    public static CustomPlate customPlate;
    private static boolean running = true;
    public static final String dtf = "yyyyMMdd-HHmmss";


    public static void customOrderScreen() {
        InputHandler.clearScreen();

        WelcomeScreen.showTitle();

        customOrderTitle();

        askCustomerName();

        showSizeMenu();

        while (running) {
            orderMenu();

            userOrderOptions();
        }


    }

    public static void customOrderTitle() {
        System.out.printf("\n\t%s%s%s%s%s%s%s%s%s\n", PlateOptions.equals, ConsoleColors.BLUE, PlateOptions.customPl, ConsoleColors.RESET, PlateOptions.a, ConsoleColors.RED, PlateOptions.teMenu, ConsoleColors.RESET, PlateOptions.equals);
    }

    public static void askCustomerName() {
        customerName = InputHandler.getStringInput("\nEnter your name: ");
    }

    public static void showSizeMenu() {


        System.out.printf("\nWhat size plate would you like? (Allowed Portions)\n\n\t%s%d - %s%s %s%s\n\t%s%d - %s%s %s%s\n\t%s%d - %s%s %s%s%s\n",
                ConsoleColors.BLUE_BOLD, PlateOptions.sizeSmall, ConsoleColors.RED, PlateOptions.sizeSmallText, ConsoleColors.BLUE, PlateOptions.smallSizes,
                ConsoleColors.BLUE_BOLD, PlateOptions.sizeMedium, ConsoleColors.RED, PlateOptions.sizeMediumText, ConsoleColors.BLUE, PlateOptions.mediumSizes,
                ConsoleColors.BLUE_BOLD, PlateOptions.sizeLarge, ConsoleColors.RED, PlateOptions.sizeLargeText, ConsoleColors.BLUE, PlateOptions.largeSizes, ConsoleColors.RESET);

        size = InputHandler.getSizeInput("\nEnter Desired Size: ");
    }

    public static void orderMenu() {

        System.out.println("\nWhat would you like today?");
        final String menuFormat =
                        "\n%s%d. - %s%s" +
                        "\n%s%d. - %s%s" +
                        "\n%s%d. - %s%s" +
                        "\n%s%d. - %s%s" +
                        "\n%s%d. - %s%s%s%n";
        System.out.printf(menuFormat,
                ConsoleColors.BLUE, PlateOptions.addMain, ConsoleColors.RED, PlateOptions.addMainText,
                ConsoleColors.BLUE, PlateOptions.addSide, ConsoleColors.RED, PlateOptions.addSideText,
                ConsoleColors.BLUE, PlateOptions.addDrink, ConsoleColors.RED, PlateOptions.addDrinkText,
                ConsoleColors.BLUE, PlateOptions.checkOut, ConsoleColors.RED, PlateOptions.checkOutText,
                ConsoleColors.BLUE, PlateOptions.cancelOrder, ConsoleColors.RED, PlateOptions.cancelOrderText,
                ConsoleColors.RESET);
    }

    public static void pineappleQuestion() {
        String pineappleChoice = InputHandler.getStringInput("\nWould you like to plate your food in a Pineapple for an additional $2.50 (yes/no): ").toLowerCase();

        pineappleBowl = pineappleChoice.equals("yes") || pineappleChoice.equals("y");
    }


    public static String randomId() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rnd = new Random();
        return IntStream.range(0, 5)
                .map(i -> chars.charAt(rnd.nextInt(chars.length())))
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

    }



    public static void createCustomPlate() {
        customPlate = new CustomPlate(pineappleBowl, plate, size, customerName);
        currentOrder = new Order(randomId(), ZonedDateTime.now(), customPlate, customPlate.getPrice());
        System.out.println("\nYour custom plate has been created and added to your order!");
    }



    public static void checkOut() {
        createCustomPlate();
        CheckoutScreen.showSummary(currentOrder);
        System.out.println("\nProceeding to checkout...");
        if (CheckoutScreen.confirmOrder()) {
            System.out.println(ReceiptManager.createReceipt(currentOrder));
            InputHandler.exit();
        } else {
            orderMenu();
            userOrderOptions();
        }
    }

    public static void cancelOrder() {
        if (InputHandler.getYesOrNoInput("\nAre you sure you want to cancel your order? (y/n): ")) {
            plate.clear();
            selectedMains.clear();
            selectedDrinks.clear();
            selectedSides.clear();
            running = false;
            System.out.println("\nYour order has been cancelled. Returning to Home Screen...");
            WelcomeScreen.run();
        } else {
            System.out.println("\nReturning to Order Menu...");
            orderMenu();
            userOrderOptions();
        }

    }

    public static void getPlateItems() {
        System.out.println("\nCurrent items on your plate: " + customPlate.getSize());
        plate.forEach(item -> System.out.println("- " + item.getItemName()));

    }

    public static void userOrderOptions() {
        InputHandler.emptyLine();
        int choice = InputHandler.getUserIntInput("Enter a number Option: ");

        switch (choice) {
            case PlateOptions.addMain:
                addMain();
                break;
            case PlateOptions.addSide:
                addSide();
                break;
            case PlateOptions.addDrink:
                addDrink();
                break;
            case PlateOptions.checkOut:
                checkOut();
                break;
            case PlateOptions.cancelOrder:
                cancelOrder();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }

    }

}
