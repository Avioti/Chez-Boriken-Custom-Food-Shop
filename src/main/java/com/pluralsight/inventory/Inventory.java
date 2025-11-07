package com.pluralsight.inventory;

import java.util.List;
import java.util.Optional;

public class Inventory {
    List<Food> items;

    public void LoadFromCsv(String filePath) {

    }

    public void reduceStock(Food item, int quantity) {

    }

    public List<Food> getItems() {
        return items;
    }

    public List<Food> getItemsByCategory(String category) {
        return null;
    }

    public Optional<Food> getItemByName(String itemName) {
        return Optional.empty();
    }


}
