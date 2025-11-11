package com.pluralsight.ui;

import com.pluralsight.order.Order;
import com.pluralsight.utility.InputHandler;


public class CheckoutScreen extends OrderScreen{

    public static void showSummary(Order order){
        System.out.println("\nOrder Summary");
        getPlateItems();
        System.out.printf("\nTotal Price: $%.2f%n", customPlate.getPrice());

    }

    public static boolean confirmOrder(){
        if(InputHandler.getYesOrNoInput("\n Would you like to confirm your order? (yes/no): ")){
            System.out.println("\nOrder confirmed! Thank you for dining with us.");
            return true;
        }
        System.out.println("\nOrder not confirmed. You can modify your order.");
        return false;
    }


}
