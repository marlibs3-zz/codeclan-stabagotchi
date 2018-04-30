package com.example.martabeveridge.stabagotchi;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PetTest {

    Pet puppy;

    @Before
    public void before() {
        puppy = new Pet("Taco", 1, 100, 0);
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

}
