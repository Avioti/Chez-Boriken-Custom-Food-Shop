package com.pluralsight.utility;

import com.pluralsight.constants.ConsoleColors;
import com.pluralsight.constants.Size;
import com.pluralsight.inventory.Food;
import com.pluralsight.ui.HomeScreen;
import com.pluralsight.ui.WelcomeScreen;

import java.util.InputMismatchException;
import java.util.Scanner;


public class InputHandler {

    private static final int INVALID_INPUT = -1;
    public static final String RETURN_TO_MENU_MESSAGE = "Press Enter to return to menu";
    private static final String EXIT_MESSAGE = "Thank you for Visiting ";
    private static final String EXIT_ONE = "Chez ";
    private static final String EXIT_TWO = "Boriken!";
    private static final int CLEAR_SCREEN_LINES = 60;
    public static Scanner scanner = new Scanner(System.in);
    public static boolean running = true;


    public static Boolean getYesOrNoInput(String prompt) {
        System.out.print(prompt + "(y/n): ");
        String input = scanner.nextLine().trim().toLowerCase();
        if (input.equals("y") || input.equals("yes")) {
            return true;
        } else if (input.equals("n") || input.equals("no")) {
            return false;
        } else {
            return false;
        }
    }

    public static Size getSizeInput(String prompt) {
        System.out.print(prompt);
        int choice = getUserChoice();
        return switch (choice) {
            case 2 -> Size.MEDIUM;
            case 3 -> Size.LARGE;
            default -> Size.SMALL;
        };
    }

    public static int getUserChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return INVALID_INPUT;
        }
    }

    public static Double getUserAnswer() {
        try {
            Double choice = scanner.nextDouble();
            scanner.nextLine();
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return 0.00;
        }
    }

    public static String getStringInput(String prompt) {

        System.out.print(prompt);


        return scanner.nextLine().trim();
    }


    public static int getUserIntInput(String prompt) {
        System.out.print(prompt);


        return getUserChoice();
    }

    public static void waitForEnter(String prompt) {
        System.out.println("\n" + prompt);
        scanner.nextLine();
    }

    public static void waitForEnter() {
        waitForEnter(RETURN_TO_MENU_MESSAGE);
        clearScreen();
        WelcomeScreen.showTitle();
        HomeScreen.showEntrees();
        HomeScreen.showMenuChoices();
        HomeScreen.userHomeOptions();
    }



    public static void clearScreen() {
        for (int i = 0; i < CLEAR_SCREEN_LINES; i++) {
            emptyLine();
        }
    }
    public static void clearScreen(int amount) {
        for (int i = 0; i < amount; i++) {
            emptyLine();
        }
    }

    public static void exit() {
        emptyLine();
        final String exitFormat = "\t%s%s%s%s%s%s%s%n";
        System.out.printf(exitFormat, ConsoleColors.BOLD, EXIT_MESSAGE, ConsoleColors.RED_BOLD, EXIT_ONE, ConsoleColors.BLUE_BOLD, EXIT_TWO, ConsoleColors.RESET);
        scanner.close();
        System.exit(0);
        running = false;
    }

    public static void emptyLine() {
        System.out.println();
    }

}
