package com.pluralsight.ui;

import com.pluralsight.constants.ConsoleColors;
import com.pluralsight.constants.MenuOptions;
import com.pluralsight.inventory.InventoryHandler;
import com.pluralsight.products.EntreeBuilder;
import com.pluralsight.utility.InputHandler;

import static com.pluralsight.constants.MenuOptions.*;
import static com.pluralsight.utility.InputHandler.*;


public class WelcomeScreen {


    public static void run() {
        InputHandler.clearScreen();
        InventoryHandler.loadFromCsv();
        showTitle();
        showWelcomePrompt();
        EntreeBuilder.defaultEntrees();
        mainLoop();


    }

    public static void showTitle() {

        final String titleFormat = "%s%s " + "%s%s%s%n";
        System.out.printf(titleFormat, ConsoleColors.BLUE, MenuOptions.chez, ConsoleColors.RED, MenuOptions.boriken, ConsoleColors.RESET);


    }


    private static void showWelcomePrompt() {
        System.out.println("\t\t\t   Welcome to Chez Boriken!");
        waitForEnter(pleaseEnterText);
    }

    private void viewReceipts() {

    }

    public static void mainLoop() {
        while (running) {
            InputHandler.clearScreen();
            showTitle();
            HomeScreen.showEntrees();
            HomeScreen.showMenuChoices();
            HomeScreen.userHomeOptions();

        }

    }


}
