package com.pluralsight.ui;



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
        System.out.println("\nEnter the quantity you would like to add: ");
        int userInput = InputHandler.getUserChoice();


        int limit = switch(food.getCategory().toLowerCase()) {
            case "main" -> size.getMainLimit();
            case "side" -> size.getSideLimit();
            case "drink" -> size.getDrinkLimit();
            default -> 0;
        };

        if (userInput < limit) {
            return userInput;
        } else {
            return 1;
        }
    }

    public static void addFoodItem(Food food) {
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

            promptAddMore();
        } else {
            System.out.println("\nYou have reached the maximum portion of Mains to add to your plate.");
            orderMenu();
            userOrderOptions();
        }

        if (sideCount < size.getSideLimit()) {

            promptAddMore();
        } else {
            System.out.println("\nYou have reached the maximum portion of Sides to add to your plate.");
            orderMenu();
            userOrderOptions();
        }

        if (drinkCount < size.getDrinkLimit()) {

            promptAddMore();
        } else {
            System.out.println("\nYou have reached the maximum portion of Drinks to add to your plate.");
            orderMenu();
            userOrderOptions();
        }
    }

    private static void promptAddMore() {
        System.out.println("\nWould you like to add more items to your plate?");
        if (InputHandler.getYesOrNoInput("\nEnter yes or no: \n")) {
            addFoodItem(promptAddExtra());
        } else {
            System.out.println("\nReturning to Order Menu...");
            orderMenu();
            userOrderOptions();
        }
    }


    public static Food promptAddExtra()  {
        System.out.println("\nAdd Item - Select Extra Item by Name:");
        return InventoryHandler.getItemByName(scanner.nextLine().trim());
    }

    public static Food promptSelectMain() {
        System.out.println("\nAdd Item - Select Main Item by Name:");
        return InventoryHandler.getItemByName(scanner.nextLine().trim());
    }

    public static Food promptSelectSide() {
        System.out.println("\nAdd Item - Select Side Item by Name:");
        return InventoryHandler.getItemByName(scanner.nextLine().trim());
    }

    public static Food promptSelectDrink() {
        System.out.println("\nAdd Item - Select Drink Item by Name:");
        return InventoryHandler.getItemByName(scanner.nextLine().trim());
    }
}
