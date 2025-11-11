package com.pluralsight.ui;

import com.pluralsight.order.Order;
import com.pluralsight.utility.InputHandler;

public class CheckoutScreen {

    public static void showSummary(Order order){
        System.out.println("Order Summary:");
        order.getItems().forEach(item ->
            System.out.println(item.getProduct() + " - $" + item.getTotalPrice())
        );



    }

    public static boolean confirmOrder(){
        if(InputHandler.getYesOrNoInput("\n Would you like to confirm your order? (yes/no): ")){
            System.out.println("\nOrder confirmed! Thank you for dining with us.");
            return true;
        }
        System.out.println("\nOrder not confirmed. You can modify your order.");
        return false;
    }

    public void cancelOrder(){

    }
}
