package com.example.martabeveridge.stabagotchi;

public class Game {

    private Pet pet;

    public Game(Pet pet) {
        this.pet = pet;
    }

    public void levelUp() {
        int currentLovePoints = pet.getLovePoints();
        if (currentLovePoints == 100) {
            pet.levelUp();
        }
    }

    public void replenishHealth(Foods food) {
        int currentHealthDeficit = 100 - pet.getHealthPoints();
        
        if (food.getHpRestoreValue() < currentHealthDeficit) {
            int newHealthPoints = pet.getHealthPoints() + food.getHpRestoreValue();
            pet.setHealthPoints(newHealthPoints);
        }
        else {
            pet.setHealthPoints(100);
        }
    }

//    public void feed(Foods food) {
//        if (food.getCostOfFood() <= pet.getLovePoints()) {
//            int lovePointsTotal;
//            lovePointsTotal = pet.getLovePoints() - food.getCostOfFood();
//            pet.setLovePoints(lovePointsTotal);
//
//            replenishHealth();
//        }
//    }

}
