package com.pluralsight.utility;

import java.util.Scanner;

public class InputHandler {
    public static Scanner scanner = new Scanner(System.in);

    public InputHandler(Scanner scanner) {
    }

    public static String getStringInput() {
        // Implementation for getting string input from the user
        System.out.println("Enter input:");
        return scanner.nextLine();
    }

    public static int getIntInput(String prompt) {
        // Implementation for getting integer input from the user
        return 0;
    }

    public static double getDoubleInput(String prompt) {
        // Implementation for getting double input from the user
        return 0.0;
    }



}
