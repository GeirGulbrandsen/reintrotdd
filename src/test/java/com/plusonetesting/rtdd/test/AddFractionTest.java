package com.plusonetesting.rtdd.test;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class AddFractionTest {

    @Test
    public void zeroPlusZero() {
        Fraction sum = new Fraction(0).plus(new Fraction(0));
        assertThat(sum.intValue() ,is(0));
    }

    @Test
    public void nonZeroPlusZero() {
        Fraction sum = new Fraction(3).plus(new Fraction(0));
        assertThat(sum.intValue(), is(3));
    }

    @Test
    public void zeroPlusNonZero() {
        Fraction sum = new Fraction(0).plus(new Fraction(5));
        assertThat(sum.intValue(), is(5));
    }

    @Test
    public void nonNegativeNonZeroOperands() {
        Fraction sum = new Fraction(3).plus(new Fraction(4));
        assertThat(sum.intValue(), is(7));
    }

    @Test
    public void negativePlusPositiveWithNegativeResult() {
        Fraction sum = new Fraction(-3).plus(new Fraction(1));
        assertThat(sum.intValue(), is(-2));
    }
}
