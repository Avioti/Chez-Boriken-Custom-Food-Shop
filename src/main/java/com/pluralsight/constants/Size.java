package com.pluralsight.constants;

public enum Size {
    SMALL(1,1,1,1.0),
    MEDIUM(2,2,1,1.5),
    LARGE(3,3,2,2.0);

    private Size(int mainLimit, int sideLimit, int drinkLimit,double priceMultiplier) {
        this.mainLimit = mainLimit;
        this.sideLimit = sideLimit;
        this.drinkLimit = drinkLimit;
        this.priceMultiplier = priceMultiplier;
    }

    final int mainLimit;
    final int sideLimit;
    final int drinkLimit;
    final double priceMultiplier;

    public int getMainLimit() {
        return mainLimit;
    }

    public int getSideLimit() {
        return sideLimit;
    }

    public int getDrinkLimit() {
        return drinkLimit;
    }

    public double getPriceMultiplier() {
        return priceMultiplier;
    }




    public static Size fromString(String sizeStr) {
        for (Size size : Size.values()) {
            if (size.name().equalsIgnoreCase(sizeStr)) {
                return size;
            }
        }
        throw new IllegalArgumentException("No enum constant for size: " + sizeStr);
    }

}
