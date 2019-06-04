package com.plusonetesting.rtdd.addfractions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FractionEqualsTest {

    @Test
    public void sameNumeratorAndDenominator() {
        assertEquals(new Fraction(3, 5), new Fraction(3, 5));
    }

    @Test
    public void differentNumerators() {
        assertNotEquals(new Fraction(1, 5), new Fraction(3, 5));
    }

    @Test
    public void differentDenominators() {
        assertNotEquals(new Fraction(3, 4), new Fraction(3, 7));
    }

    @Test
    public void wholeNumberEqualsSameFraction() {
        assertEquals(new Fraction(5,1), new Fraction(5) );
    }

    @Test
    public void wholeNumberNotEqualToDifferentWholeNumber() {
        assertNotEquals(new Fraction(6), new Fraction(5));
    }

    @Test
    public void negativeDenominator() {
        assertEquals(new Fraction(1,2), new Fraction(-1,-2));
        assertEquals(new Fraction(-1,2), new Fraction(1,-2));
    }
}
