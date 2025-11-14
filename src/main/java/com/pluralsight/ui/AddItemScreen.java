package com.pluralsight.ui;


import com.pluralsight.constants.ConsoleColors;
import com.pluralsight.constants.PlateOptions;
import com.pluralsight.inventory.*;
import com.pluralsight.utility.InputHandler;

import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;


import static com.pluralsight.utility.InputHandler.scanner;

public class AddItemScreen extends OrderScreen {
    public static List<Food> selectedMains = new ArrayList<>();
    public static List<Food> selectedSides = new ArrayList<>();
    public static List<Food> selectedDrinks = new ArrayList<>();


    public static int getSizeInputInt(Food food) {
        System.out.printf("%s%s%s%s%s%s%s%s ", ConsoleColors.BLUE, PlateOptions.enterQuantityPart1, ConsoleColors.RESET,
                ConsoleColors.BOLD, PlateOptions.enterQuantityPart2,
                ConsoleColors.RED, PlateOptions.enterQuantityPart3, ConsoleColors.RESET);
        int userInput = InputHandler.getUserChoice();

        int currentSize = getSize(food);

        int limit = getLimit(food);

        if (currentSize + 1 > limit) {
            return 0;
        }

        if (userInput < limit && userInput < currentSize + 1) {
            return userInput;
        } else {
            System.out.println(ConsoleColors.RED + PlateOptions.invalidQuantity + ConsoleColors.RESET);
            return 0;
        }
    }

    public static int getSize(Food food) {
        return food instanceof Main ? selectedMains.size() :
                food instanceof Side ? selectedSides.size() :
                        food instanceof Drink ? selectedDrinks.size() : 0;
    }


    private static int getLimit(Food food) {
        return switch (food.getCategory().toLowerCase()) {
            case "main" -> size.getMainLimit();
            case "side" -> size.getSideLimit();
            case "drink" -> size.getDrinkLimit();
            default -> 0;
        };
    }

    private static String getTypeString(Food food) {
        return food instanceof Main ? PlateOptions.mainType :
                food instanceof Side ? PlateOptions.sideType :
                        food instanceof Drink ? PlateOptions.drinkType : "";
    }

    public static void addFoodItem(Food food) {
        try {
            if (!food.isAvailable()) {
                System.out.printf("%s%s%s\n", ConsoleColors.RED, PlateOptions.invalidOption, ConsoleColors.RESET);
                return;
            }

            int currentSize = getSize(food);
            int limit = getLimit(food);

            if (currentSize + 1 > limit) {
                System.out.printf("%s%s%s%s%s%s%s%s%s\n", ConsoleColors.BLUE, PlateOptions.maxPortionPart1,
                        ConsoleColors.BOLD, PlateOptions.maxPortionPart2,
                        ConsoleColors.RED, getTypeString(food),
                        ConsoleColors.BOLD, PlateOptions.maxPortionPart3, ConsoleColors.RESET);
                return;
            }

        } catch (Exception e) {
            System.out.printf("%s%s%s\n", ConsoleColors.RED, PlateOptions.invalidOption, ConsoleColors.RESET);
            e.printStackTrace();
        }
        plate.add(food);
        if (food instanceof Main main) {
            selectedMains.add(main);
        } else if (food instanceof Side side) {
            selectedSides.add(side);
        } else if (food instanceof Drink drink) {
            selectedDrinks.add(drink);
        }
        InventoryHandler.reduceStock(food, getSizeInputInt(food));
    }

    public static void addMoreItems() {
        checkCategoryLimit(selectedMains.size(), size.getMainLimit(), PlateOptions.mainType);
        checkCategoryLimit(selectedSides.size(), size.getSideLimit(), PlateOptions.sideType);
        checkCategoryLimit(selectedDrinks.size(), size.getDrinkLimit(), PlateOptions.drinkType);
    }

    private static void checkCategoryLimit(int currentCount, int limit, String type) {
        if (currentCount < limit) {
            orderMenu();
            userOrderOptions();
        } else {
            System.out.printf("%s%s%s%s%s%s%s%s%s\n", ConsoleColors.BLUE, PlateOptions.maxPortionPart1,
                    ConsoleColors.BOLD, PlateOptions.maxPortionPart2,
                    ConsoleColors.RED, type,
                    ConsoleColors.BOLD, PlateOptions.maxPortionPart3, ConsoleColors.RESET);
            checkOut();
        }
    }


    public static Food promptAddExtra() {
        System.out.printf("%s%s%s%s%s%s", ConsoleColors.BOLD, PlateOptions.addItem, ConsoleColors.RESET, ConsoleColors.RED, PlateOptions.selectExtraItem, ConsoleColors.RESET);
        return InventoryHandler.getItemByName(scanner.nextLine().trim());
    }

    public static Food promptSelectMain() {
        System.out.printf("%s%s%s%s%s%s", ConsoleColors.BOLD, PlateOptions.addItem, ConsoleColors.RESET, ConsoleColors.RED, PlateOptions.selectMainItem, ConsoleColors.RESET);
        return InventoryHandler.getItemByName(scanner.nextLine().trim());
    }

    public static Food promptSelectSide() {
        System.out.printf("%s%s%s%s%s%s", ConsoleColors.BOLD, PlateOptions.addItem, ConsoleColors.BLUE, PlateOptions.selectSideItem, ConsoleColors.RED, ConsoleColors.RESET);
        return InventoryHandler.getItemByName(scanner.nextLine().trim());
    }

    public static Food promptSelectDrink() {
        System.out.printf("%s%s%s%s%s%s", ConsoleColors.BOLD, PlateOptions.addItem, ConsoleColors.RESET, ConsoleColors.RED, PlateOptions.selectDrinkItem, ConsoleColors.RESET);
        return InventoryHandler.getItemByName(scanner.nextLine().trim());
    }
}
