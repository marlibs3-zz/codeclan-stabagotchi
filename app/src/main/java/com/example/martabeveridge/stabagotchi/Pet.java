package com.example.martabeveridge.stabagotchi;

public class Pet {

    private String name;
    private int level;
    private int healthPoints;
    private int lovePoints;

    public Pet(String name, int level, int healthPoints, int lovePoints) {
        this.name = name;
        this.level = level;
        this.healthPoints = healthPoints;
        this.lovePoints = lovePoints;
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
