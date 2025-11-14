package com.pluralsight.constants;

import static com.pluralsight.products.EntreeBuilder.featuredEntrees;

public class PlateOptions {
    // Custom Plate Title Parts
    public static final String equals = "===";
    public static final String customPl = " Custom Pl";
    public static final String a = "a";
    public static final String teMenu = "te Menu ";

    // Order Menu Options
    public static final int addMain = 1;
    public static final int addSide = 2;
    public static final int addDrink = 3;
    public static final int changeSize = 4;
    public static final int checkOut = 5;
    public static final int cancelOrder = 0;

    public static final String addMainText = " Add Main";
    public static final String addSideText = " Add Side";
    public static final String addDrinkText = " Add Drink";
    public static final String changeSizeText = " Change PLate Size";
    public static final String checkOutText = " Check Out";
    public static final String cancelOrderText = " Cancel Order";

    // Size Options
    public static final int sizeSmall = 1;
    public static final int sizeMedium = 2;
    public static final int sizeLarge = 3;
    public static final String sizeSmallText = " Small";
    public static final String smallSizes = "(Mains: 1, Sides: 1, Drinks: 1)";
    public static final String mediumSizes = "(Mains: 2, Sides: 1, Drinks: 1)";
    public static final String largeSizes = "(Mains: 3, Sides: 2, Drinks: 2)";
    public static final String sizeMediumText = " Medium";
    public static final String sizeLargeText = " Large";
    public static final String invalidQuantity = "\nInvalid quantity. Please enter within the Plate Limits.";

    // Pineapple Plate Option
    public static final String pineappleQuestion = String.format("%s%s%s%s%s%s%s%s%s", ConsoleColors.BLUE, "\nWould you like to plate your food in a ", ConsoleColors.RESET, ConsoleColors.BOLD, "Pineapple", ConsoleColors.RED_BOLD, " for an additional $2.50 ", ConsoleColors.RESET, "(yes/no): ");
    public static final double pineapplePrice = 2.50;

    // Entree Order Prompts
    public static final String orderEntreePrompt = "\n Please select an entree to order:\n";
    public static final String entreeOption1Text = featuredEntrees.get(0).getDisplayName();
    public static final String entreeOption2Text = featuredEntrees.get(1).getDisplayName();
    public static final String entreeOption3Text = featuredEntrees.get(2).getDisplayName();
    public static final int entreeOption1 = featuredEntrees.get(0).getId();
    public static final int entreeOption2 = featuredEntrees.get(1).getId();
    public static final int entreeOption3 = featuredEntrees.get(2).getId();
    public static final int orderEntree = 1;
    public static final String orderEntreeText = " Choose Entree";
    public static final int editEntree = 2;
    public static final String editEntreeText = " Edit Entree";
    public static final int entreeMenuExit = 0;
    public static final String entreeMenuExitText = " Return to Home Screen";
    public static final String currentEntreeItems = "\nCurrent items in your entree: ";
    public static final String noEntreeToEdit = "\nThere is no entree to edit. Please order an entree first.";
    public static final int entreeCheckout = 3;
    public static final String noEntreeToCheckout = "\nThere is no entree to check out. Please order an entree first.";

    //Order Menu Prompts
    public static final String whatWouldYouLike = "\nWhat would you like today?";
    public static final String whatWould = " What would ";
    public static final String you = "you";
    public static final String likeToday = " like today? ";
    public static final String enterDesiredSize = String.format("%s%s%s%s%s%s",ConsoleColors.BLUE,"\nEnter " + ConsoleColors.RESET,ConsoleColors.BOLD,"Desired " + ConsoleColors.RED,"Size: ",ConsoleColors.RESET);
    public static final String currentItemsOnPlate = "\nCurrent items on your plate: ";
    public static final String invalidOption = "Invalid option. Please try again.";
    public static final String enterNumberOption = String.format("%s%s%s%s%s%s",ConsoleColors.BLUE,"\nEnter " +ConsoleColors.RESET, ConsoleColors.BOLD,"a number " + ConsoleColors.RED,"Option: ",ConsoleColors.RESET);
    public static final String customPlateCreated = "\nYour plate has been created and added to your order!";
    public static final String proceedingToCheckout = "\n\tProceeding to checkout...";
    public static final String orderCancelled = "\nYour order has been cancelled.";
    public static final String returningToOrderMenu = "\nReturning to Order Menu...";
    public static final String mustAddItem = "\nYou must add at least one Side or Drink to your plate before proceeding to checkout.";
    public static final String areYouSure = "\nAre you sure you want to cancel your order? ";
    public static final String whatSizePlate = "\nWhat size plate would you like? (Allowed Portions)";
    public static final String order = " Order ";
    public static final String summary = "Summary ";

    //Add Item Prompts
    public static final String enterQuantityPart1 = "\nEnter the ";
    public static final String enterQuantityPart2 = "quantity";
    public static final String enterQuantityPart3 = " you would like to add: ";
    public static final String maxPortionPart1 = "\nYou have reached the ";
    public static final String maxPortionPart2 = "maximum portion of ";
    public static final String maxPortionPart3 = " to add to your plate.";
    public static final String mainType = "Mains";
    public static final String sideType = "Sides";
    public static final String drinkType = "Drinks";
    public static final String addMoreItems = "\nWould you like to add more items to your plate?";
    public static final String enterYesOrNo = "\nEnter yes or no: ";
    public static final String addItem = "\nAdd Item - ";
    public static final String selectExtraItem = "Select Extra Item by Name: ";
    public static final String selectMainItem = "Select Main Item by Name: ";
    public static final String selectSideItem = "Select Side Item by Name: ";
    public static final String selectDrinkItem = "Select Drink Item by Name: ";

    public static final String alert = " ALERT! ";




    private PlateOptions() {
        throw new AssertionError("Cannot instantiate constants class");
    }
}
