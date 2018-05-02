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

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void setLovePoints(int lovePoints) {
        this.lovePoints = lovePoints;
    }

    public void addLovePoint() {
        lovePoints++;
    }

    public void levelUp(){
        level++;
    }

    public boolean canGainThisMuchHealth(int healthToBeAdded){
        int currentHealthDeficit = 100 - getHealthPoints();
        return healthToBeAdded <= currentHealthDeficit;
    }

    public boolean canAffordThisFood(int costOfFood) {
        return costOfFood < getLovePoints();
    }

    public void increaseHealthBy(int foodHealthValue, int foodCost) {
        if (canAffordThisFood(foodCost)) {
            if (canGainThisMuchHealth(foodHealthValue)) {
                int newHealthPoints = foodHealthValue + getHealthPoints();
                setHealthPoints(newHealthPoints);
                int newLovePoints = lovePoints - foodCost;
                setLovePoints(newLovePoints);
            }
        }
    }
}
