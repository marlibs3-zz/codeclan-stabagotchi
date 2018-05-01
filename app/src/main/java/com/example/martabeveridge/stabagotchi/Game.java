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

}
