package com.pluralsight.constants;

public enum Size {
    SMALL(2,1,1),
    MEDIUM(3,2,1),
    LARGE(4,3,2);

    private Size(int mainLimit, int sideLimit, int drinkLimit) {
        this.mainLimit = mainLimit;
        this.sideLimit = sideLimit;
        this.drinkLimit = drinkLimit;
        this.priceMultiplier = 1 + (ordinal() * 0.25);
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

}
