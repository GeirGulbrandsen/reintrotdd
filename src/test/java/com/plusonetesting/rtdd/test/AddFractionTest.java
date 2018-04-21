package com.plusonetesting.rtdd.test;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class AddFractionTest {

    @Test
    public void zeroPlusZero() {
        assertThat(new Fraction(0).plus(new Fraction(0)).intValue() ,is(0));
    }

    @Test
    public void nonZeroPlusZero() {
        assertThat(new Fraction(3).plus(new Fraction(0)).intValue(), is(3));
    }

    @Test
    public void zeroPlusNonZero() {
        assertThat(new Fraction(0).plus(new Fraction(5)).intValue(), is(5));
    }

    @Test
    public void nonNegativeNonZeroOperands() {
        assertThat(new Fraction(3).plus(new Fraction(4)).intValue(), is(7));
    }

    @Test
    public void negativePlusPositiveWithNegativeResult() {
        assertThat(new Fraction(-3).plus(new Fraction(1)).intValue(), is(-2));
    }

    @Test
    public void nonTrivialButCommonDenominatior() {

        Fraction sum = new Fraction(1, 5).plus(new Fraction(2, 5));

        assertThat(sum.getNumerator(), is(3));
        assertThat(sum.getDenominator(), is(5));
    }


}
