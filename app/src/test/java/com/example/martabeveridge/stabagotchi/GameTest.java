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
    public void levelsUpAt100() {
        puppy.setLovePoints(99);
        puppy.addLovePoint();
        game.levelUp();
        assertEquals(2, puppy.getLevel());
    }

}
