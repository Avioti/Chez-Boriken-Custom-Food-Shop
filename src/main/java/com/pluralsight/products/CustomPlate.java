package com.pluralsight.products;

import com.pluralsight.core.Orderable;
import com.pluralsight.inventory.*;
import com.pluralsight.utility.Size;

import java.util.ArrayList;
import java.util.List;

public class CustomPlate implements Orderable {
    String PlateName;
    Size size;
    List<Food> selectedMains,selectedSides,selectedDrinks = new ArrayList<>();
    boolean pineappleBowl;
    double pineappleBowlPrice = 2.00;

    public CustomPlate(boolean pineappleBowl, List<Food> selectedDrinks, List<Food> selectedSides, List<Food> selectedMains, Size size, String plateName) {
        this.pineappleBowl = pineappleBowl;
        this.selectedDrinks = selectedDrinks;
        this.selectedSides = selectedSides;
        this.selectedMains = selectedMains;
        this.size = size;
        PlateName = plateName;
    }

    public boolean addMain(Main item) {
        return selectedMains.add(item);
    }

    public boolean addSide(Side item) {
        return selectedSides.add(item);
    }

    public boolean addDrink(Drink item) {
        return selectedDrinks.add(item);
    }

    public void setPineappleBowl(boolean option) {
        this.pineappleBowl = option;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getDisplayName() {
        return "";
    }

    public boolean assemblePlate(InventoryHandler inv){
        return true;
    }

    public String display(){
        return null;
    }
}
