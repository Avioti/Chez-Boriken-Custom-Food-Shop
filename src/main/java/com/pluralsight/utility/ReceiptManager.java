package com.pluralsight.utility;

import com.pluralsight.constants.ConsoleColors;
import com.pluralsight.order.Order;
import com.pluralsight.products.CustomPlate;
import com.pluralsight.products.Entree;
import com.pluralsight.ui.OrderScreen;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;


import static com.pluralsight.ui.OrderScreen.dtf;

public class ReceiptManager {
    final static String receiptFolder = "src/main/resources/receipts/";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern(dtf);
    private static final File directory = new File(receiptFolder);
    private static final File[] files = directory.listFiles();




    public static String createReceipt(Order order) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(receiptFolder + order.getCreatedAt().format(DATE_FORMAT)+".txt"));

            String receiptContent = "";

            if(order.getPlate() != null && order.getPlate() instanceof CustomPlate plate){
                receiptContent = order.getId() + "|" + plate.getDisplayName() + "|" +  order.getPlate();
            } else if (order.getPlate() != null && order.getPlate() instanceof Entree entree) {
                receiptContent = order.getId() + "|" + entree.getDisplayName() + "|" + "|" + entree.getMain().getItemName() + "|" +
                        entree.getSide().getItemName() + "|" + entree.getDrink().getItemName() + "|" + entree.getDescription();
            }

            writer.write(receiptContent);
            writer.flush();
            writer.close();
        }catch (Exception e){
            e.printStackTrace();}



        return String.format("\n\t%s%s%s%s%s%s%s%s%s%s%s%s%s", ConsoleColors.BLUE, "Receipt for order #",
                ConsoleColors.RED, order.getId(), ConsoleColors.BLUE, "|",ConsoleColors.RESET, ConsoleColors.BOLD,
                order.getTotalPrice(), ConsoleColors.BLUE, "|", order.getCreatedAt().format(DATE_FORMAT), ConsoleColors.RESET);
    }


    public static void displayReceipts(){
        if(files != null){
            Arrays.stream(files).forEach(file -> {
                try{
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line;
                    while((line = reader.readLine()) != null){
                        String[] parts = line.split("\\|");
                        //temp printout
                        System.out.println("\nReceipt File: " + file.getName());
                        System.out.printf("%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s\n",
                                ConsoleColors.BLUE, "\tOrder ID: ",
                                ConsoleColors.RESET, ConsoleColors.BOLD, parts[0],
                                ConsoleColors.BLUE, "|Name: ",
                                ConsoleColors.RESET, ConsoleColors.BOLD, parts[1],
                                ConsoleColors.BLUE, "|Plate - ",
                                ConsoleColors.RESET, ConsoleColors.BOLD,
                                ConsoleColors.RED_BOLD, parts[3] + "|" + parts[4] + "|" + parts[5] + "|" + parts[6],ConsoleColors.RESET);
                    }
                    reader.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        } else {
            System.out.println("No receipts found.");
        }

        InputHandler.waitForEnter();
    }
}
