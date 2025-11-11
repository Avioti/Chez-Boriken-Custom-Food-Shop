package com.pluralsight.ui;


import com.pluralsight.inventory.*;
import com.pluralsight.utility.InputHandler;


import static com.pluralsight.utility.InputHandler.scanner;

public class AddItemScreen extends OrderScreen{





    public static void addFoodItem(Food food){
        plate.add(food);
        InventoryHandler.reduceStock(food,1);
    }

    public static void addMoreItems(){
        if(plate.size() + 1  < size.getMainLimit()){
            Food food = AddItemScreen.promptSelectMain();
            System.out.println("\nWould you like to add more items to your plate?");
            if(InputHandler.getYesOrNoInput("\nEnter yes or no: \n")){
                addFoodItem(food);
            } else {
                System.out.println("\nReturning to Order Menu...");
                orderMenu();
                userOrderOptions();
            }
        }else{
            System.out.println("\nYou have reached the maximum portions of Mains to add to your plate.");
            orderMenu();
            userOrderOptions();
        }

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
