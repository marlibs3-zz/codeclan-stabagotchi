package com.example.martabeveridge.stabagotchi;

import java.io.Serializable;

public class Game implements Serializable{

    private Pet pet;

    public Game(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
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
