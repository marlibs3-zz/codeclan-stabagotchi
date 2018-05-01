package com.example.martabeveridge.stabagotchi;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Foods treat;
    private Pet puppy;
    private Game game;

    @Before
    public void before() {
        treat = Foods.TREAT;
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

    @Test
    public void canReplenishHealth() {
        puppy.setHealthPoints(1);
        game.replenishHealth(treat);
        assertEquals(26, puppy.getHealthPoints());
    }

//    @Test
//    public void canFeedPet() {
//        puppy.setLovePoints(50);
//        game.feed(treat);
//        assertEquals(25, puppy.getLovePoints());
//    }

}
