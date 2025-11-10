package com.pluralsight.constants;

public class PlateOptions {
    public static final int addMain = 1;
    public static final int addSide = 2;
    public static final int addDrink = 3;
    public static final int checkOut = 4;
    public static final int cancelOrder = 0;

    public static final String addMainText = " Add Main";
    public static final String addSideText = " Add Side";
    public static final String addDrinkText = " Add Drink";
    public static final String checkOutText = " Check Out";
    public static final String cancelOrderText = " Cancel Order";


    private PlateOptions() {
        throw new AssertionError("Cannot instantiate constants class");
    }
}
