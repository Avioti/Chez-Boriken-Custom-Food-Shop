package com.pluralsight.products;

import com.pluralsight.constants.ConsoleColors;
import com.pluralsight.constants.PlateOptions;
import com.pluralsight.core.Orderable;
import com.pluralsight.inventory.*;
import com.pluralsight.constants.Size;
import com.pluralsight.ui.AddItemScreen;
import com.pluralsight.utility.InputHandler;

import java.util.List;

import static com.pluralsight.ui.AddItemScreen.*;
import static com.pluralsight.ui.OrderScreen.pineappleQuestion;

public class CustomPlate implements Orderable {
    String customerName;
    static Size size;
    public static List<Food> selectedFood;
    boolean pineappleBowl;
    double pineappleBowlPrice = 2.00;


    public CustomPlate(boolean pineappleBowl, List<Food> selectedFood, Size size, String customerName) {
        this.pineappleBowl = pineappleBowl;
        this.selectedFood = selectedFood;
        this.size = size;
        this.customerName = customerName;
    }


    public void setPineappleBowl(boolean option) {
        this.pineappleBowl = option;
    }

    public Size getSize() {
        return size;
    }

    public static void addMain() {

        InputHandler.emptyLine();
        InventoryHandler.getItemsByCategory("main");

        addFoodItem(AddItemScreen.promptSelectMain());
        pineappleQuestion();
        addMoreItems();




    }

    public static void addSide() {

        InputHandler.emptyLine();
        InventoryHandler.getItemsByCategory("Side");
        addFoodItem(AddItemScreen.promptSelectSide());
        addMoreItems();


    }

    public static void addDrink() {

        InputHandler.emptyLine();
        InventoryHandler.getItemsByCategory("Drink");
        addFoodItem(AddItemScreen.promptSelectDrink());
        addMoreItems();

    }

    public static void plateSizeCheck() {
        for(Food item : selectedFood) {
            if (item.getCategory().equalsIgnoreCase("main")) {
                if (selectedFood.stream().filter(f -> f.getCategory().equalsIgnoreCase("main")).count() > size.getMainLimit()) {
                    System.out.printf("\n%s%s%s You have reached the maximum number of mains for a %s plate.%s\n",
                            ConsoleColors.RED, PlateOptions.alert, ConsoleColors.RESET, size.name().toLowerCase(), PlateOptions.equals);
                    selectedFood.remove(item);
                    InventoryHandler.increaseStock(item, 1);
                }
            } else if (item.getCategory().equalsIgnoreCase("side")) {
                if (selectedFood.stream().filter(f -> f.getCategory().equalsIgnoreCase("side")).count() > size.getSideLimit()) {
                    System.out.printf("\n%s%s%s You have reached the maximum number of sides for a %s plate.%s\n",
                            ConsoleColors.RED, PlateOptions.alert, ConsoleColors.RESET, size.name().toLowerCase(), PlateOptions.equals);
                    selectedFood.remove(item);
                    InventoryHandler.increaseStock(item, 1);
                }
            } else if (item.getCategory().equalsIgnoreCase("drink")) {
                if (selectedFood.stream().filter(f -> f.getCategory().equalsIgnoreCase("drink")).count() > size.getDrinkLimit()) {
                    System.out.printf("\n%s%s%s You have reached the maximum number of drinks for a %s plate.%s\n",
                            ConsoleColors.RED, PlateOptions.alert, ConsoleColors.RESET, size.name().toLowerCase(), PlateOptions.equals);
                    selectedFood.remove(item);
                    InventoryHandler.increaseStock(item, 1);
                }
            }
        }
    }

    @Override
    public double getPrice() {
        if (selectedFood.isEmpty()) {
            return 0;
        }

        double totalPrice = selectedFood.stream()
                .mapToDouble(item -> {
                    if (size == Size.SMALL)
                        return item.getBasePrice();
                    else if (size == Size.MEDIUM)
                        return item.getBasePrice() * size.getPriceMultiplier();
                    else if (size == Size.LARGE)
                        return item.getBasePrice() * size.getPriceMultiplier();
                    else return 0;
                })
                .sum();

        if (pineappleBowl) {
            totalPrice += pineappleBowlPrice;
        }
        return totalPrice;


    }

    @Override
    public String getDisplayName() {
        return customerName;
    }

    @Override
    public String toString() {
        return "|" + size.name() +
                "|" + (pineappleBowl ? "Yes" : "No") +
                "|" + selectedFood.stream()
                .map(Food::getItemName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("None") +
                "|Total: $" + String.format("%.2f", getPrice());
    }
}
