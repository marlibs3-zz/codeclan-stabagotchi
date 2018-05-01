package com.example.martabeveridge.stabagotchi;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PetTest {

    Pet puppy;

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
        assertEquals(100, puppy.getHealthPoints());
    }

    @Test
    public void hasLovePoints() {
        assertEquals(0, puppy.getLovePoints());
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

}
