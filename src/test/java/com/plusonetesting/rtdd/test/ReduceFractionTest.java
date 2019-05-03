package com.plusonetesting.rtdd.test;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ReduceFractionTest {

    @Test
    public void alreadyInLowestTerms() {
        assertEquals(new Fraction(3, 4), new Fraction(3, 4));
    }

    @Test
    @Ignore("Waiting to implement GCD")
    public void reduceToNotWholeNumber() {
        assertEquals(new Fraction(3,4), new Fraction(6,8));
    }
}
