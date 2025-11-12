package com.pluralsight.utility;

import com.pluralsight.order.Order;
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

            if(order.getCustomPlate() != null){
                receiptContent = order.getId() + "|" + order.getTotalPrice() + "|" + order.getCustomPlate().getDisplayName();
            } else if (order.getEntree() != null) {
                receiptContent = order.getId() + "|" + order.getTotalPrice() + "|" + order.getEntree().getDisplayName();
            }

            writer.write(receiptContent);
            writer.close();
        }catch (Exception e){
            e.printStackTrace();}



        return "Receipt for order #" + order.getId() + "|" + order.getTotalPrice() + "|" + order.getCreatedAt();
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
                        System.out.println("Receipt File: " + file.getName());
                        System.out.printf("\tOrder ID: %s | Total Price: $%.2f | Item: %s%n", parts[0], Double.parseDouble(parts[1]), parts[2]);
                    }
                    reader.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        } else {
            System.out.println("No receipts found.");
        }

        InputHandler.waitAndContinue();
    }
}
