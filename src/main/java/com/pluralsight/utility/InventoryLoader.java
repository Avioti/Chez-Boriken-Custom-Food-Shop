package com.pluralsight.utility;

import com.pluralsight.inventory.Drink;
import com.pluralsight.inventory.Food;
import com.pluralsight.inventory.Main;
import com.pluralsight.inventory.Side;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public abstract class InventoryLoader {
    protected final String filePath = "src/main/resources/inventory.csv";
    protected static List<Food> items = new ArrayList<>();
    final static String errorMessage = "Error loading inventory from CSV file.";


    public void parseLines(String[] parts) {
        int quantity = Integer.parseInt(parts[0]);
        String category = parts[1];
        String itemName = parts[2];
        String description = parts[3];
        double basePrice = Double.parseDouble(parts[4]);
        if(category.equalsIgnoreCase("drink")){
            int ounces = Integer.parseInt(parts[5]);
            Drink drink = new Drink(quantity, category, itemName, description, basePrice, ounces);
            items.add(drink);
        }  if (category.equalsIgnoreCase("main")) {
            Main main = new Main(quantity, category, itemName, description, basePrice);
            items.add(main);
        }  if (category.equalsIgnoreCase("side")) {
            Side side = new Side(quantity, category, itemName, description, basePrice);
            items.add(side);
        }

    }

    public void loadFromCsv() {

        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String input;

            while((input = reader.readLine()) != null){
                String[] parts = input.split("\\|");
                 parseLines(parts);

            }
            reader.close();


        }catch (Exception e){
            e.printStackTrace();
            System.out.println(errorMessage);

        }
    }
}
