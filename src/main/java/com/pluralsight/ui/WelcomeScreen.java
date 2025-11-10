package com.pluralsight.ui;

import com.pluralsight.constants.ConsoleColors;
import com.pluralsight.constants.MenuOptions;


public class WelcomeScreen {

    public void run() {
        showTitle();
        showWelcomePrompt();

    }

    private void showTitle() {

        final String titleFormat = "%s%s " + "%s%s%s%n";
        System.out.printf(titleFormat, ConsoleColors.BLUE, MenuOptions.chez, ConsoleColors.RED, MenuOptions.boriken, ConsoleColors.RESET);


    }


    private void showWelcomePrompt() {
        System.out.println("\t\t\t   Welcome to Chez Boriken!");
        System.out.println("\t\t        Press Enter to Order...");
    }

    private void viewReceipts() {

    }


}
