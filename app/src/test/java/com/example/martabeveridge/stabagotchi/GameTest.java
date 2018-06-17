package com.example.martabeveridge.stabagotchi;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Pet puppy;
    private Game game;

    @Before
    public void before() {
        puppy = new Pet("Taco");
        game = new Game(puppy);
    }

    @Test
    public void startsAtLevel1() {
        assertEquals(1, puppy.getLevel());
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
    public void feedIncreasesHealth() {
        puppy.setLovePoints(100);
        game.feed(Foods.BIGBOWL);
        assertEquals(100, puppy.getHealthPoints());
    }

    @Test
    public void feedDecreasesMoney() {
        game.feed(Foods.BOWL);
        assertEquals(180, puppy.getLovePoints());
    }
}


