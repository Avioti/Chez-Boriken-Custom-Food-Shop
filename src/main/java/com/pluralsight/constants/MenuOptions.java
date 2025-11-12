package com.pluralsight.constants;

public class MenuOptions {
    public static final String chez = "\t\t ______     __  __     ______     ______    \n" +
            "\t\t/\\  ___\\   /\\ \\_\\ \\   /\\  ___\\   /\\___  \\   \n" +
            "\t\t\\ \\ \\____  \\ \\  __ \\  \\ \\  __\\   \\/_/  /__  \n" +
            "\t\t \\ \\_____\\  \\ \\_\\ \\_\\  \\ \\_____\\   /\\_____\\ \n" +
            "\t\t  \\/_____/   \\/_/\\/_/   \\/_____/   \\/_____/ \n" +
            "\t\t                                            ";

    public static final String boriken = " \n" +
            " ______     ______     ______     __     __  __     ______     __   __    \n" +
            "/\\  == \\   /\\  __ \\   /\\  == \\   /\\ \\   /\\ \\/ /    /\\  ___\\   /\\ \"-.\\ \\   \n" +
            "\\ \\  __<   \\ \\ \\/\\ \\  \\ \\  __<   \\ \\ \\  \\ \\  _\"-.  \\ \\  __\\   \\ \\ \\-.  \\  \n" +
            " \\ \\_____\\  \\ \\_____\\  \\ \\_\\ \\_\\  \\ \\_\\  \\ \\_\\ \\_\\  \\ \\_____\\  \\ \\_\\\\\"\\_\\ \n" +
            "  \\/_____/   \\/_____/   \\/_/ /_/   \\/_/   \\/_/\\/_/   \\/_____/   \\/_/ \\/_/ \n" +
            "                                                                          ";

    public static final String menuPrompt = "\n Please select an option:\n";
    public static final int customOrder = 1;
    public static final int orderEntree = 2;
    public static final int viewReceipts = 3;
    public static final int exit = 4;
    public static final String customOrderText = " Create Custom Plate";
    public static final String orderEntreeText = " Order Entree";
    public static final String viewReceiptsText = " View Receipts";
    public static final String exitText = " Exit Application";
    public static final String invalidOptionText = " Invalid option. Please try again.";
    public static final String pleaseEnterText = "\t\t        Press Enter to Order...";

    private MenuOptions() {
        throw new AssertionError("Cannot instantiate constants class");
    }

}
