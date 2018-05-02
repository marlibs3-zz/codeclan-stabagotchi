package com.example.martabeveridge.stabagotchi;

// This enum contains all the different types of food you can feed the pet. The first value is the
// cost of the food in lv (love points) and the second one is the health it restores in hp.

public enum Foods {

    TREAT("Treat", 25, 1),
    BOWL("Bowl", 50, 5),
    BIGBOWL("Big bowl", 100, 10),
    RIBS("Ribs", 150, 15),
    STEAK("Steak", 200, 20),
    ROASTCHICKEN("Roast, chicken", 250, 30);


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
