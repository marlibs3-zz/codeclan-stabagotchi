package com.example.martabeveridge.stabagotchi;

public class Pet {

    private String name;
    private int level;
    private int healthPoints;
    private int lovePoints;

    public Pet(String name) {
        this.name = name;
        this.level = 1;
        this.healthPoints = 100;
        this.lovePoints = 0;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getLovePoints() {
        return lovePoints;
    }
}
