package com.pluralsight.inventory;


import com.pluralsight.products.Entree;
import com.pluralsight.utility.InventoryLoader;


public class InventoryHandler extends InventoryLoader {


    public static void reduceStock(Food item, int quantity) {
        int currentStock = item.getQuantity();
        if (quantity > currentStock) {
            System.out.println("Insufficient stock for " + item.getItemName());
        } else {
            item.setQuantity(currentStock - quantity);
            System.out.println("Stock updated for " + item.getItemName() + ". New quantity: " + item.getQuantity());
        }

    }

    public static void reduceStockBulk(Entree food, int quantity) {
      Food main = food.getMain();
        Food side = food.getSide();
        Food drink = food.getDrink();
        if (main instanceof Main item){
            reduceStock(item, quantity);
        }
        if (side instanceof Side item){
            reduceStock(item, quantity);
        }
        if (drink instanceof Drink item){
            reduceStock(item, quantity);
        }
    }

    public static void printAllItems() {
        items.stream()
                .filter(Food::isAvailable)
                .forEach(item -> System.out.println("- " + item.getItemName() + ": $" + item.getBasePrice()));
    }

    public static Food getItemsByCategory(String category) {
        return items.stream()
                .filter(c -> c.getCategory().equalsIgnoreCase(category))
                .findFirst()
                .orElseThrow();
    }

    public static Food getItemByName(String itemName) {
        return items.stream()
                .filter(n -> n.getItemName().replaceAll("\\s","").equalsIgnoreCase(itemName.replaceAll("\\s","")))
                .findFirst()
                .orElseThrow();
    }

    public static Food lowPriceFilter(double lowerThan) {
        return items.stream()
                .filter(i -> i.getBasePrice() < lowerThan)
                .findFirst()
                .orElseThrow();
    }

    public static double addItemsTogether(Food item1, Food item2,Food item3) {
        return item1.getBasePrice() + item2.getBasePrice()+ item3.getBasePrice();
    }


}
