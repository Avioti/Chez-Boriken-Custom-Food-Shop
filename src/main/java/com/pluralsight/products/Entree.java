package com.pluralsight.products;

import com.pluralsight.core.Orderable;
import com.pluralsight.inventory.Food;
import com.pluralsight.inventory.Inventory;

import java.util.HashMap;

public class Entree implements Orderable {
    String id,name,description;
    HashMap<Food,Integer> recipeComponents;
    double basePrice;

    public Entree(String id, String name, HashMap<Food,Integer> recipeComponents, double basePrice , String description) {
        this.id = id;
        this.name = name;
        this.recipeComponents = recipeComponents;
        this.basePrice = basePrice;
        this.description = description;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getDisplayName() {
        return "";
    }

    public boolean assemble(Inventory inv){
        for(Food item:recipeComponents.keySet()){
            if(inv.getItemByName(item.itemName).isEmpty() || !inv.getItemByName(item.itemName).get().isAvailable()){
                return false;
            }
        }
        return true;
    }

    public void release(Inventory inv){
        for(Food item:recipeComponents.keySet()){
            inv.reduceStock(item,recipeComponents.get(item));
        }
    }

    public String display(){
        return name;
    }
}
