package com.example.martabeveridge.stabagotchi;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Foods treat;
    private Foods bigbowl;
    private Pet puppy;
    private Game game;

    @Before
    public void before() {
        treat = Foods.TREAT;
        bigbowl = Foods.BIGBOWL;
        puppy = new Pet("Taco");
        game = new Game(puppy);
    }

    @Test
    public void levelsUpAt100() {
        puppy.setLovePoints(99);
        assertEquals(1, puppy.getLevel());
        puppy.addLovePoint();
        game.levelUp();
        assertEquals(2, puppy.getLevel());
    }

//    @Test
//    public void canReplenishHealth() {
//        puppy.setHealthPoints(1);
//        game.replenishHealth(bigbowl);
//        assertEquals(11, puppy.getHealthPoints());
//    }
//
//    @Test
//    public void canReplenishHealthNearMax() {
//        puppy.setHealthPoints(99);
//        game.replenishHealth(bigbowl);
//        assertEquals(100, puppy.getHealthPoints());
//    }
//
//    @Test
//    public void canFeedPet() {
//        puppy.setHealthPoints(99);
//        puppy.setLovePoints(150);
//        game.feed(bigbowl);
//        assertEquals(50, puppy.getLovePoints());
//        assertEquals(100, puppy.getHealthPoints());
//    }
//
//    @Test
//    public void canFeedPetNotEnoughLovePoints() {
//        puppy.setHealthPoints(50);
//        puppy.setLovePoints(5);
//        game.feed(bigbowl);
//        assertEquals(5, puppy.getLovePoints());
//        assertEquals(50, puppy.getHealthPoints());
//    }

}


