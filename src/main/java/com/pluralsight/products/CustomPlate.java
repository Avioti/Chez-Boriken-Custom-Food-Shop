package com.pluralsight.products;

import com.pluralsight.core.Orderable;
import com.pluralsight.inventory.*;
import com.pluralsight.constants.Size;
import com.pluralsight.ui.AddItemScreen;
import com.pluralsight.utility.InputHandler;

import java.util.ArrayList;
import java.util.List;

import static com.pluralsight.ui.AddItemScreen.addFoodItem;
import static com.pluralsight.ui.AddItemScreen.addMoreItems;
import static com.pluralsight.ui.OrderScreen.pineappleQuestion;

public class CustomPlate implements Orderable {
    String customerName;
    Size size;
    List<Food> selectedFood;
    boolean pineappleBowl;
    double pineappleBowlPrice = 2.00;

    public CustomPlate(boolean pineappleBowl, List<Food> selectedFood, Size size, String customerName) {
        this.pineappleBowl = pineappleBowl;
        this.selectedFood = selectedFood;
        this.size = size;
        this.customerName = customerName;    }


    public void setPineappleBowl(boolean option) {
        this.pineappleBowl = option;
    }



    public static void addMain(){
        InputHandler.emptyLine();
        InventoryHandler.getItemsByCategory("main");
        addFoodItem(AddItemScreen.promptSelectMain());
        addMoreItems();
        pineappleQuestion();


    }

    public static void addSide(){
        InputHandler.emptyLine();
        InventoryHandler.getItemsByCategory("Side");
        addFoodItem(AddItemScreen.promptSelectSide());
        addMoreItems();


    }

    public static void addDrink(){
        InputHandler.emptyLine();
        InventoryHandler.getItemsByCategory("Drink");
        addFoodItem(AddItemScreen.promptSelectDrink());
        addMoreItems();

    }

    @Override
    public double getPrice() {
        for(Food item : selectedFood){
            if(size == Size.SMALL){
                return item.getBasePrice();
            } else if (size == Size.MEDIUM) {
                return item.getBasePrice() * 1.5;
            } else if (size == Size.LARGE) {
                return item.getBasePrice() * 2;
            }
        }
        return 0;
    }

    @Override
    public String getDisplayName() {
        return customerName;
    }

    @Override
    public String toString() {
        return "CustomPlate{" +
                "customerName='" + customerName + '\'' +
                ", size=" + size +
                ", selectedFood=" + selectedFood +
                ", pineappleBowl=" + pineappleBowl +
                ", pineappleBowlPrice=" + pineappleBowlPrice +
                '}';
    }
}
