package com.example.martabeveridge.stabagotchi;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PetTest {

    private Pet puppy;

    @Before
    public void before() {
        puppy = new Pet("Taco");
    }

    @Test
    public void hasName() {
        assertEquals("Taco", puppy.getName());
    }

    @Test
    public void hasLevel() {
        assertEquals(1, puppy.getLevel());
    }

    @Test
    public void hasHealthPoints() {
        assertEquals(75, puppy.getHealthPoints());
    }

    @Test
    public void hasLovePoints() {
        assertEquals(200, puppy.getLovePoints());
    }

    @Test
    public void canSetLevel() {
        puppy.setLevel(2);
        assertEquals(2, puppy.getLevel());
    }

    @Test
    public void canSetHealthPoints() {
        puppy.setHealthPoints(99);
        assertEquals(99, puppy.getHealthPoints());
    }

    @Test
    public void canSetLovePoints() {
        puppy.setLovePoints(1);
        assertEquals(1, puppy.getLovePoints());
    }

    @Test
    public void canAddLovePoint() {
        puppy.addLovePoint();
        assertEquals(201, puppy.getLovePoints());
    }

    @Test
    public void canLevelUp() {
        puppy.levelUp();
        puppy.levelUp();
        assertEquals(3, puppy.getLevel());
    }

//    @Test
//    public void canTellIfCanGainThisMuchHealth() {
//        puppy.setHealthPoints(1);
//        assertEquals(true, puppy.canGainThisMuchHealth(10));
//    }
//
//    @Test
//    public void canTellIfCanGainThisMuchHealth__not() {
//        puppy.setHealthPoints(99);
//        assertEquals(false, puppy.canGainThisMuchHealth(10));
//    }

    @Test
    public void canAffordThisFood() {
        puppy.setLovePoints(100);
        assertEquals(true, puppy.canAffordThisFood(50));
    }

    @Test
    public void cannotAffordThisFood() {
        puppy.setLovePoints(5);
        assertEquals(false, puppy.canAffordThisFood(10));
    }

    @Test
    public void canIncreaseHealth() {
        puppy.setHealthPoints(5);
        puppy.setLovePoints(100);
        puppy.increaseHealthBy(10, 20);
        assertEquals(15, puppy.getHealthPoints());
        assertEquals(80, puppy.getLovePoints());
    }

    @Test
    public void cannotIncreaseHealth__cannotAfford() {
        puppy.setHealthPoints(5);
        puppy.setLovePoints(10);
        puppy.increaseHealthBy(10, 20);
        assertEquals(5, puppy.getHealthPoints());
        assertEquals(10, puppy.getLovePoints());
    }

    @Test
    public void canDecreaseHealthByOne() {
        puppy.decreaseHealthByOne();
        assertEquals(74, puppy.getHealthPoints());
    }

}
