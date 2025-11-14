package com.pluralsight.ui;


import com.pluralsight.constants.ConsoleColors;
import com.pluralsight.constants.PlateOptions;
import com.pluralsight.inventory.*;
import com.pluralsight.utility.InputHandler;

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


        int limit = switch (food.getCategory().toLowerCase()) {
            case "main" -> size.getMainLimit();
            case "side" -> size.getSideLimit();
            case "drink" -> size.getDrinkLimit();
            default -> 0;
        };

        if (userInput <= limit) {
            return userInput;
        } else {
            System.out.printf("%s%s%s",ConsoleColors.RED,"\nAdding Default Maximum Quantity for Selected Size.\n",ConsoleColors.RESET);
            return switch (food.getCategory().toLowerCase()) {
                case "main" -> size.getMainLimit();
                case "side" -> size.getSideLimit();
                case "drink" -> size.getDrinkLimit();
                default -> 0;
            };
        }
    }



    public static void addFoodItem(Food food) {
        try {
            if (food == null || !food.isAvailable()) {
                System.out.printf("%s%s%s\n", ConsoleColors.RED, PlateOptions.invalidOption, ConsoleColors.RESET);
                return;
            }

            if (food instanceof Main) {
                if (selectedMains.size() >= size.getMainLimit()) {
                    System.out.printf("%s%s%s%s%s%s%s%s%s\n", ConsoleColors.BLUE, PlateOptions.maxPortionPart1,
                            ConsoleColors.BOLD, PlateOptions.maxPortionPart2,
                            ConsoleColors.RED, PlateOptions.mainType,
                            ConsoleColors.BOLD, PlateOptions.maxPortionPart3, ConsoleColors.RESET);
                    return;
                }
            } else if (food instanceof Side) {
                if (selectedSides.size() >= size.getSideLimit()) {
                    System.out.printf("%s%s%s%s%s%s%s%s%s\n", ConsoleColors.BLUE, PlateOptions.maxPortionPart1,
                            ConsoleColors.BOLD, PlateOptions.maxPortionPart2,
                            ConsoleColors.RED, PlateOptions.sideType,
                            ConsoleColors.BOLD, PlateOptions.maxPortionPart3, ConsoleColors.RESET);
                    return;
                }
            } else if (food instanceof Drink) {
                if (selectedDrinks.size() >= size.getDrinkLimit()) {
                    System.out.printf("%s%s%s%s%s%s%s%s%s\n", ConsoleColors.BLUE, PlateOptions.maxPortionPart1,
                            ConsoleColors.BOLD, PlateOptions.maxPortionPart2,
                            ConsoleColors.RED, PlateOptions.drinkType,
                            ConsoleColors.BOLD, PlateOptions.maxPortionPart3, ConsoleColors.RESET);
                    return;
                }
            }

        } catch (Exception e) {
            System.out.printf("%s%s%s\n", ConsoleColors.RED, PlateOptions.invalidOption, ConsoleColors.RESET);

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
        int mainCount = selectedMains.size();
        int sideCount = selectedSides.size();
        int drinkCount = selectedDrinks.size();

        if (mainCount < size.getMainLimit()) {
            orderMenu();
            userOrderOptions();
        } else {
            System.out.printf("%s%s%s%s%s%s%s%s%s\n", ConsoleColors.BLUE, PlateOptions.maxPortionPart1,
                    ConsoleColors.BOLD, PlateOptions.maxPortionPart2,
                    ConsoleColors.RED, PlateOptions.mainType,
                    ConsoleColors.BOLD, PlateOptions.maxPortionPart3, ConsoleColors.RESET);
            checkOut();
        }

        if (sideCount < size.getSideLimit()) {
            orderMenu();
            userOrderOptions();
        } else {
            System.out.printf("%s%s%s%s%s%s%s%s%s\n", ConsoleColors.BLUE, PlateOptions.maxPortionPart1,
                    ConsoleColors.BOLD, PlateOptions.maxPortionPart2,
                    ConsoleColors.RED, PlateOptions.sideType,
                    ConsoleColors.BOLD, PlateOptions.maxPortionPart3, ConsoleColors.RESET);
            checkOut();
        }

        if (drinkCount < size.getDrinkLimit()) {
            orderMenu();
            userOrderOptions();
        } else {
            System.out.printf("%s%s%s%s%s%s%s%s%s\n", ConsoleColors.BLUE, PlateOptions.maxPortionPart1,
                    ConsoleColors.BOLD, PlateOptions.maxPortionPart2,
                    ConsoleColors.RED, PlateOptions.drinkType,
                    ConsoleColors.BOLD, PlateOptions.maxPortionPart3, ConsoleColors.RESET);
            checkOut();
        }
    }

    private static void promptAddMore() {
        System.out.println("\nWould you like to add more items to your plate?");
        if (InputHandler.getYesOrNoInput(String.format("%s%s%s", ConsoleColors.BLUE, PlateOptions.enterYesOrNo, ConsoleColors.RESET))) {
            addFoodItem(promptAddExtra());
        } else {
            System.out.println("\nGoing to Checkout...");
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
