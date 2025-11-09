package com.pluralsight.inventory;


import com.pluralsight.utility.InventoryLoader;


public class InventoryHandler extends InventoryLoader {


    public void reduceStock(Food item, int quantity) {
        int currentStock = item.getQuantity();
        if (quantity > currentStock) {
            System.out.println("Insufficient stock for " + item.getItemName());
        } else {
            item.setQuantity(currentStock - quantity);
            System.out.println("Stock updated for " + item.getItemName() + ". New quantity: " + item.getQuantity());
        }

    }

    public void printAllItems() {
        items.stream()
                .filter(Food::isAvailable)
                .forEach(item -> System.out.println("- " + item.getItemName() + ": $" + item.getBasePrice()));
    }

    public void getItemsByCategory(String category) {
        items.stream()
                .filter(c -> c.getCategory().equalsIgnoreCase(category))
                .forEach(item -> System.out.println("- " + item.getItemName() + ": $" + item.getBasePrice()));
    }

    public void getItemByName(String itemName) {
        items.stream()
                .filter(i -> i.getItemName().equalsIgnoreCase(itemName))
                .forEach(item -> System.out.println("- " + item.getItemName() + ": $" + item.getBasePrice()));
    }

    public void lowPriceFilter(double lowerThan) {
        items.stream()
                .filter(i -> i.getBasePrice() < lowerThan)
                .forEach(item -> System.out.println("- " + item.getItemName() + ": $" + item.getBasePrice()));
    }




}
