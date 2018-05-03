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
        int foodHealthValue = food.getHpRestoreValue();
        int foodCost = food.getCostOfFood();
        pet.increaseHealthBy(foodHealthValue, foodCost);
    }

    public void feed(Foods food) {
        if (food.getCostOfFood() <= pet.getLovePoints()) {
            replenishHealth(food);
        }
    }

}
