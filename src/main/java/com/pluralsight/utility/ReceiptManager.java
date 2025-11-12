package com.pluralsight.utility;

import com.pluralsight.order.Order;
import com.pluralsight.ui.OrderScreen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;


import static com.pluralsight.ui.OrderScreen.dtf;

public class ReceiptManager {
    final static String receiptFolder = "src/main/resources/receipts/";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern(dtf);
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

    public void loadReceipts() {
        // Logic to load existing receipts from the receiptFolder
    }

    public static void displayReceipts(){
        File directory = new File(receiptFolder);

        File[] files = directory.listFiles();

        if(files != null){
            for(File file : files){
                System.out.println("Receipt File: " + file.getName());
            }
        } else {
            System.out.println("No receipts found.");
        }

        InputHandler.waitForEnter();
    }
}
