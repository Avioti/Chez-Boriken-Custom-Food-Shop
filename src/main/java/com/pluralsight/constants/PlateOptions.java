package com.pluralsight.constants;

public class PlateOptions {
    public static final String equals = "===";
    public static final String customPl = " Custom Pl";
    public static final String a = "a";
    public static final String teMenu = "te Menu ";
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

    public static final int sizeSmall = 1;
    public static final int sizeMedium = 2;
    public static final int sizeLarge = 3;
    public static final String sizeSmallText = " Small";
    public static final String smallSizes = "(Mains: 2, Sides: 1, Drinks: 1)";
    public static final String mediumSizes = "(Mains: 3, Sides: 2, Drinks: 1)";
    public static final String largeSizes = "(Mains: 4, Sides: 3, Drinks: 2)";

    public static final String sizeMediumText = " Medium";
    public static final String sizeLargeText = " Large";


    private PlateOptions() {
        throw new AssertionError("Cannot instantiate constants class");
    }
}
