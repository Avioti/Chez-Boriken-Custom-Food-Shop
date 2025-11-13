package com.pluralsight.ui;

import com.pluralsight.constants.ConsoleColors;
import com.pluralsight.constants.PlateOptions;
import com.pluralsight.constants.Size;
import com.pluralsight.inventory.Drink;
import com.pluralsight.inventory.Food;
import com.pluralsight.inventory.Main;
import com.pluralsight.inventory.Side;
import com.pluralsight.order.Order;
import com.pluralsight.products.CustomPlate;
import com.pluralsight.utility.InputHandler;
import com.pluralsight.utility.ReceiptManager;


import java.time.ZonedDateTime;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.pluralsight.products.CustomPlate.*;
import static com.pluralsight.ui.AddItemScreen.*;

public class OrderScreen {
    private static Order currentOrder;
    protected static Size size;
    static public ArrayList<Food> plate = new ArrayList<>();
    private static String customerName;
    private static boolean pineappleBowl;
    public static CustomPlate customPlate;
    public static boolean running = true;
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
        customerName = InputHandler.getStringInput(String.format("%s%s%s%s%s%s", ConsoleColors.BLUE, "\nEnter " + ConsoleColors.RESET, ConsoleColors.BOLD, "Your " + ConsoleColors.RED, "Name: ", ConsoleColors.RESET));
    }

    public static void showSizeMenu() {


        System.out.printf("\nWhat size plate would you like? (Allowed Portions)\n\n\t%s%d - %s%s %s%s\n\t%s%d - %s%s %s%s\n\t%s%d - %s%s %s%s%s\n",
                ConsoleColors.BLUE_BOLD, PlateOptions.sizeSmall, ConsoleColors.RED, PlateOptions.sizeSmallText, ConsoleColors.BLUE, PlateOptions.smallSizes,
                ConsoleColors.BLUE_BOLD, PlateOptions.sizeMedium, ConsoleColors.RED, PlateOptions.sizeMediumText, ConsoleColors.BLUE, PlateOptions.mediumSizes,
                ConsoleColors.BLUE_BOLD, PlateOptions.sizeLarge, ConsoleColors.RED, PlateOptions.sizeLargeText, ConsoleColors.BLUE, PlateOptions.largeSizes, ConsoleColors.RESET);

        size = InputHandler.getSizeInput(PlateOptions.enterDesiredSize);
    }

    public static void orderMenu() {

        System.out.printf("\n%s%s%s%s%s%s%s%s%s\n",PlateOptions.equals,ConsoleColors.BLUE,PlateOptions.whatWould,ConsoleColors.RESET,PlateOptions.you,ConsoleColors.RED
                ,PlateOptions.likeToday,ConsoleColors.RESET,PlateOptions.equals);

        System.out.printf("\n\t%s%d. - %s%s" +
                        "\n\t%s%d. - %s%s" +
                        "\n\t%s%d. - %s%s" +
                        "\n\t%s%d. - %s%s" +
                        "\n\t%s%d. - %s%s" +
                        "\n\t%s%d. - %s%s%s%n",
                ConsoleColors.BLUE, PlateOptions.addMain, ConsoleColors.RED, PlateOptions.addMainText,
                ConsoleColors.BLUE, PlateOptions.addSide, ConsoleColors.RED, PlateOptions.addSideText,
                ConsoleColors.BLUE, PlateOptions.addDrink, ConsoleColors.RED, PlateOptions.addDrinkText,
                ConsoleColors.BLUE, PlateOptions.changeSize, ConsoleColors.RED, PlateOptions.changeSizeText,
                ConsoleColors.BLUE, PlateOptions.checkOut, ConsoleColors.RED, PlateOptions.checkOutText,
                ConsoleColors.BLUE, PlateOptions.cancelOrder, ConsoleColors.RED, PlateOptions.cancelOrderText,
                ConsoleColors.RESET);
    }

    public static void pineappleQuestion() {
        if(pineappleBowl) {
            return;
        }
        String pineappleChoice = InputHandler.getStringInput(PlateOptions.pineappleQuestion).toLowerCase();

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
        System.out.printf("%s%s%s\n", ConsoleColors.GREEN_BOLD, PlateOptions.customPlateCreated, ConsoleColors.RESET);
    }


    public static void cartCheck() {
        if (selectedMains.isEmpty() && selectedSides.isEmpty() && selectedDrinks.isEmpty()) {
            System.out.printf("%s%s%s\n", ConsoleColors.RED_BOLD, PlateOptions.mustAddItem, ConsoleColors.RESET);
            orderMenu();
            userOrderOptions();
        }
    }


    public static void checkOut() {
        cartCheck();
        createCustomPlate();
        CheckoutScreen.showSummary(currentOrder);
        System.out.printf("\t%s%s%s\n", ConsoleColors.BLUE_BOLD, PlateOptions.proceedingToCheckout, ConsoleColors.RESET);
        if (CheckoutScreen.confirmOrder()) {
            System.out.println(ReceiptManager.createReceipt(currentOrder));
            CheckoutScreen.addAnotherOrder();
        } else {
            cancelOrder();
        }
    }

    public static void cancelOrder() {
        if (InputHandler.getYesOrNoInput(PlateOptions.areYouSure)) {
            plate.clear();
            selectedMains.clear();
            selectedDrinks.clear();
            selectedSides.clear();
            running = false;
            System.out.printf("%s%s%s\n", ConsoleColors.RED_BOLD, PlateOptions.orderCancelled, ConsoleColors.RESET);

            WelcomeScreen.run();
        } else {
            System.out.printf("%s%s%s\n", ConsoleColors.BLUE_BOLD, PlateOptions.returningToOrderMenu, ConsoleColors.RESET);
            orderMenu();
            userOrderOptions();
        }

    }

    public static void getPlateItems() {
        System.out.printf("%s%s%s%s%s\n", ConsoleColors.BOLD, PlateOptions.currentItemsOnPlate, ConsoleColors.RED, customPlate.getSize(), ConsoleColors.RESET);
        plate.forEach(item -> {
            String count = item instanceof Main ? String.valueOf(selectedMains.size()) :  item instanceof Side ? String.valueOf(selectedSides.size())
                    : item instanceof Drink ? String.valueOf(selectedDrinks.size()) : "0";
            System.out.printf("\n\t%s-%s %s%s %s\n", ConsoleColors.BLUE, ConsoleColors.RED, item.getItemName(), ConsoleColors.RESET, count);
        });

    }

    public static void userOrderOptions() {
        InputHandler.emptyLine();
        int choice = InputHandler.getUserIntInput(PlateOptions.enterNumberOption);

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
            case PlateOptions.changeSize:
                showSizeMenu();
                break;
            case PlateOptions.checkOut:
                checkOut();
                break;
            case PlateOptions.cancelOrder:
                cancelOrder();
                break;
            default:
                System.out.printf("%s%s%s\n", ConsoleColors.RED_BOLD, PlateOptions.invalidOption, ConsoleColors.RESET);
                break;
        }

    }

}
