package com.pluralsight.utility;

import com.pluralsight.constants.ConsoleColors;
import com.pluralsight.inventory.Drink;
import com.pluralsight.inventory.Food;
import com.pluralsight.inventory.Main;
import com.pluralsight.inventory.Side;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public abstract class InventoryLoader {
    protected static final String filePath = "src/main/resources/inventory.csv";
    protected static List<Food> items = new ArrayList<>();
    final static String errorMessage = "Error loading inventory from CSV file.";


    public static void parseLines(String[] parts) {
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

    public static void loadFromCsv() {

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

    public static void reduceStock(Food item, int quantity) {
        int currentStock = item.getQuantity();
        if (quantity > currentStock) {
            System.out.printf("%s%s%s%s%s%s\n", ConsoleColors.RED_BOLD, "\n\tInsufficient stock for ", ConsoleColors.RESET, ConsoleColors.BOLD, item.getItemName(), ConsoleColors.RESET);
        } else {
            item.setQuantity(currentStock - quantity);
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
                for (Food f : items) {
                    String line = f.getQuantity() + "|" + f.getCategory() + "|" + f.getItemName() + "|" + f.getDescription() + "|" + f.getBasePrice();
                    if (f instanceof Drink drink) {
                        line += "|" + drink.getOunces();
                    }
                    writer.write(line);
                    writer.newLine();
                }
                writer.close();

            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.printf("%s%s%s%s%s%s%s%s%s\n", ConsoleColors.BLUE, "\n\tStock for ",ConsoleColors.RESET, ConsoleColors.BOLD, item.getItemName(), ConsoleColors.RED, " Quantity: " , ConsoleColors.RESET, item.getQuantity());
        }

    }
}
