package com.plusonetesting.rtdd.test;

import org.junit.Test;

import javax.xml.stream.FactoryConfigurationError;

import static org.junit.Assert.assertEquals;


public class AddFractionTest {

    @Test
    public void zeroPlusZero() {
        assertEquals(new Fraction(0), new Fraction(0).plus(new Fraction(0)));
    }

    @Test
    public void nonZeroPlusZero() {
        assertEquals(new Fraction(3), new Fraction(3).plus(new Fraction(0)));
    }

    @Test
    public void zeroPlusNonZero() {
        assertEquals(new Fraction(5), new Fraction(0).plus(new Fraction(5)));
    }

    @Test
    public void nonNegativeNonZeroOperands() {
        assertEquals(new Fraction(7), new Fraction(3).plus(new Fraction(4)));
    }

    @Test
    public void negativePlusPositiveWithNegativeResult() {
        assertEquals(new Fraction(-2), new Fraction(-3).plus(new Fraction(1)));
    }

    @Test
    public void nonTrivialButCommonDenominator() {
        assertEquals(new Fraction(3,5), new Fraction((1), 5).plus(new Fraction(2, 5)));
    }

    @Test
    public void differentDenominatorsWithoutReducing() {
        assertEquals(new Fraction(5,6), new Fraction(1,2).plus(new Fraction(1,3)));
    }
}
