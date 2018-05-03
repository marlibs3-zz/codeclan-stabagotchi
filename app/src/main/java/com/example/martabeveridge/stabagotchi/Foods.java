package com.example.martabeveridge.stabagotchi;

// This enum contains all the different types of food you can feed the pet. The first value is the
// cost of the food in lv (love points) and the second one is the health it restores in hp.

public enum Foods {

    TREAT("Treat", 10, 2),
    BOWL("Bowl", 25, 5),
    BIGBOWL("Big bowl", 50, 10),
    RIBS("Ribs", 75, 15),
    CHICKEN("Chicken", 100, 20),
    STEAK("Steak", 150, 30);


    private final String prettyNameOfFood;
    private final int costOfFood;
    private final int hpRestoreValue;

    Foods(String prettyNameOfFood, int costOfFood, int hpRestoreValue) {
        this.prettyNameOfFood = prettyNameOfFood;
        this.costOfFood = costOfFood;
        this.hpRestoreValue = hpRestoreValue;
    }

    public String getPrettyNameOfFood() {
        return prettyNameOfFood;
    }

    public int getCostOfFood() {
        return costOfFood;
    }

    public int getHpRestoreValue() {
        return hpRestoreValue;
    }

}
